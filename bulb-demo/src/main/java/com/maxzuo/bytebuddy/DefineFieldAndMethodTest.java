package com.maxzuo.bytebuddy;

import com.maxzuo.bytebuddy.model.*;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.DefaultMethodCall;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * 使用ByteBuddy定义属性和方法
 * Created by zfh on 2019/01/28
 */
class DefineFieldAndMethodTest {

    private static final Logger logger = LoggerFactory.getLogger(DefineFieldAndMethodTest.class);

    @DisplayName("属性和方法")
    @Test
    void testFieldAndMethod () {
        try {
            // 创建一个类，匹配toString方法，给定返回值。
            Object o = new ByteBuddy()
                    .subclass(Object.class)
                    .name("com.maxzuo.bytebuddy.Bean")
                    .method(named("toString"))
                    .intercept(FixedValue.value("Hello World!"))
                    .make()
                    .load(getClass().getClassLoader())
                    .getLoaded()
                    // Java reflection API
                    .newInstance();
            // 输出：Hello World!
            System.out.println(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("匹配和覆盖方法的返回值")
    @Test
    void testMatcherMethod () {
        try {
            Fast fast = new ByteBuddy()
                    .subclass(Fast.class)
                    // 使用多个匹配条件，覆盖 所有匹配的方法
                    .method(named("m").and(returns(String.class)).and(takesArguments(1)))
                    .intercept(FixedValue.value("hello m"))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance();
            // 调用子类方法
            System.out.println(fast.m("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("使用不同的规则覆盖不同的方法")
    @Test
    void testUseDifferenceRulesOverrideMethod () {
        try {
            Foo foo = new ByteBuddy()
                    .subclass(Foo.class)
                    // 第一个规则：匹配定义的任何方法
                    .method(isDeclaredBy(Foo.class))
                    .intercept(FixedValue.value("one！"))
                    // 第二个规则：匹配命名的两个方法
                    .method(named("foo"))
                    .intercept(FixedValue.value("two!"))
                    // 第三个规格：匹配第三个方法
                    .method(named("foo").and(takesArguments(1)))
                    .intercept(FixedValue.value("three！"))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance();
            // 按照代码书写的顺序匹配，依次覆盖上一级的返回值。
            System.out.println("bar：" + foo.bar());
            System.out.println("foo：" + foo.foo());
            System.out.println("foo：" + foo.foo("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("探索方法返回固定值")
    @Test
    void testFixedValue () {
        FixedValue.AssignerConfigurable value = FixedValue.value(0);
        // TODO: 1.固定值常量池 2.存储在该类的静态变量中。
    }

    @DisplayName("非法的赋值给返回值")
    @Test
    void testIllegalAssignment () {
        try {
            Foo foo = new ByteBuddy()
                    .subclass(Foo.class)
                    .method(named("foo"))
                    .intercept(FixedValue.value(0))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance();
            System.out.println("返回值：" + foo.foo());
        } catch (Exception e) {
            // 创建类型时，整数非法赋值给返回的方法String。此时将抛出IllegalArgumentException异常
            logger.error("异常信息", e);
        }
    }

    @DisplayName("委派静态方法调用")
    @Test
    void testInvokeDelegationMethod () {
        /*
            在许多情况下，从方法返回固定值当然是不够的。为了获得更大的灵活性，Byte Buddy提供了MethodDelegation实现，它为方法调用
            提供了最大的自由度。方法委托定义了动态创建类型的方法，以将任何调用转发给可能位于动态类型之外的另一个方法。这样，动态类
            的逻辑可以使用普通Java表示，而只有通过代码生成实现与另一个方法的绑定。

            总结：
              1.Byte Buddy不要求将目标方法与 源方法 相同命名。String类型比Object类型更具体，因此匹配第一个方法。
              2.Target类如果存在 多个 相同参数不同命名的方法，将抛出不能匹配模糊性异常。
              3.Target类的方法必须是 public static 修饰的方法。
         */
        try {
            String msg = new ByteBuddy()
                    .subclass(Source.class)
                    .method(named("hello"))
                    .intercept(MethodDelegation.to(Target.class))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance()
                    .hello("dazuo");

            System.out.println("msg: " + msg);
        } catch (Exception e) {
            logger.error("异常信息", e);
        }
    }

    @DisplayName("使用@Argument注解")
    @Test
    void testArgumentAnnotations () {
        try {
            String msg = new ByteBuddy()
                    .subclass(Source.class)
                    .method(named("print"))
                    .intercept(MethodDelegation.to(Target.class))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance()
                    .print(99,"dazuo");

            // @Argument(0) 指定参数的位置
            System.out.println(msg);
        } catch (Exception e) {
            logger.error("异常信息", e);
        }
    }

    @DisplayName("委派静态方法调用-带注释的参数")
    @Test
    void testInvokeDelegationMethodAndAnnotationArgument () {
        try {
            MemoryDatabase memoryDatabase = new ByteBuddy()
                    .subclass(MemoryDatabase.class)
                    .method(named("load"))
                    .intercept(MethodDelegation.to(LoggerInterceptor.class))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance();
            List<String> list = memoryDatabase.load("args");
            System.out.println("list: " + list);
        } catch (Exception e) {
            logger.error("异常信息", e);
        }
    }

    @DisplayName("委托给实例方法")
    @Test
    void testDelegationInstanceMethod () {
        try {
            String msg = new ByteBuddy()
                    .subclass(Source.class)
                    .method(named("hello"))
                    .intercept(MethodDelegation.to(new Target()))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance()
                    .hello("hello");
            System.out.println("msg: " + msg);
        } catch (Exception e) {
            logger.error("异常信息", e);
        }
    }

    @DisplayName("调用默认方法")
    @Test
    void testInvokeDefaultMethod () {
        try {
            Class<?> aClass = new ByteBuddy(ClassFileVersion.JAVA_V8)
                    .subclass(Object.class)
                    .implement(IFast.class)
                    .implement(ISlow.class)
                    // 实现不同接口的相同方法，定义优先加载
                    .method(named("m")).intercept(DefaultMethodCall.prioritize(IFast.class))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded();

            Object o1 = aClass.newInstance();
            Method m = aClass.getMethod("m");
            Object invoke = m.invoke(o1);
            System.out.println("invoke: " + invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("访问字段")
    @Test
    void testFieldAccessor () {
        // TODO:
        try {
            Class<? extends UserType> dynamicUserType = new ByteBuddy()
                    .subclass(UserType.class)
                    .method(not(isDeclaredBy(Object.class)))
                    .intercept(MethodDelegation.toField("interceptor"))
                    .defineField("interceptor", Interceptor.class, Visibility.PRIVATE)
                    .implement(InterceptionAccessor.class)
                    .intercept(FieldAccessor.ofBeanProperty())
                    .make()
                    .load(getClass().getClassLoader())
                    .getLoaded();

            InstanceCreator factory = new ByteBuddy()
                    .subclass(InstanceCreator.class)
                    .method(not(isDeclaredBy(Object.class)))
                    .intercept(MethodDelegation.toConstructor(dynamicUserType))
                    .make()
                    .load(ClassLoader.getSystemClassLoader())
                    .getLoaded()
                    .newInstance();

            // 创建动态增强的新实例
            UserType userType = (UserType) factory.makeInstance();
            // 应用于新创建的实例
            ((InterceptionAccessor) userType).setInterceptor(new HelloWorldInterceptor());
            System.out.println(((InterceptionAccessor) userType).getInterceptor().doSomethingElse());

        } catch (Exception e) {
            logger.error("异常信息", e);
        }
    }
}
