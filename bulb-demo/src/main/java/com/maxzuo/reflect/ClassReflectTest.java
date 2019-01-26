package com.maxzuo.reflect;

import com.maxzuo.reflect.model.Token;
import com.maxzuo.reflect.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Java反射机制
 * Created by zfh on 2019/01/25
 */
@DisplayName("Java反射机制")
class ClassReflectTest {

    @DisplayName("获取Class对象")
    @Test
    void testGetClass () {
        // 方式一：通过类名获取
        Class<User> class1 = User.class;

        // 方式二：通过类的对象获取
        User user = new User();
        Class<? extends User> class2 = user.getClass();

        // 方式三：通过类的全名获取
        try {
            Class<?> class3 = Class.forName("com.maxzuo.reflect.model.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取基本类型的class对象
        Class<Integer> class4 = int.class;

        // 获取包装类的class对象
        Class<Integer> class5 = Integer.class;
    }

    @DisplayName("反射的基本信息")
    @Test
    void testClassBaseInfo () {
        Class<User> userClass = User.class;
        System.out.println("类全名：" + userClass.getName());
        System.out.println("类名：" + userClass.getSimpleName());
        // 获取类上所有注解，包括继承的
        Annotation[] annotations = userClass.getAnnotations();
        // 获取类上所有的注解，不包含继承的
        Annotation[] declaredAnnotations = userClass.getDeclaredAnnotations();

        // 获取类的类加载器
        ClassLoader classLoader = userClass.getClassLoader();
    }

    @DisplayName("构造方法的反射")
    @Test
    void testConstructorRelect () {
        Class<User> userClass = User.class;
        // 获取公共的构造方法，包括继承的
        Constructor<?>[] constructors = userClass.getConstructors();
        // 获取当前类的构造方法，包括私有的，不包含继承的
        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
        System.out.println("全类名：" + constructors[1].getName());
        System.out.println("参数类型：" + Arrays.toString(constructors[1].getParameterTypes()));
        try {
            // 构造方法的实例化对象
            Object o = constructors[1].newInstance(1, "1", 3);
            System.out.println("o：" + o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("成员变量的反射")
    @Test
    void testFieldRelect () {
        Class<User> userClass = User.class;
        // 获取当前类的公共变量，包含继承的成员变量
        Field[] fields = userClass.getFields();
        System.out.println("files count: " + fields.length);
        // 获取当前类的成员变量，包含私有的，不包含继承的
        Field[] declaredFields = userClass.getDeclaredFields();
        System.out.println("declaredFields count: " + declaredFields.length);
        System.out.println("第一个成员变量名字：" + declaredFields[0].getName());
        System.out.println("第一个成员变量类型：" +  declaredFields[0].getType());
    }

    @DisplayName("方法的反射")
    @Test
    void testMethodRelect () {
        Class<User> userClass = User.class;
        // 获取所有的公共方法，包括继承
        Method[] methods = userClass.getMethods();
        // 获取当前类的所有方法，包括私有的，不包含继承的
        Method[] declaredMethods = userClass.getDeclaredMethods();
        System.out.println("declaredMethods count: " + declaredMethods.length);
        try {
            // 方法名称和方法参数获取一个指定方法
            Method method = userClass.getDeclaredMethod("getParam", String.class);
            // 方法的调用
            System.out.println("method result：" + method.invoke(userClass.newInstance(), "hello"));

            // 获取方法上的注解
            Token token = method.getAnnotation(Token.class);
            System.out.println("注解的值：" + token.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("第三个方法的方法名：" + declaredMethods[3].getName());
        System.out.println("第三个方法的参数：" + Arrays.asList(declaredMethods[3].getParameterTypes()));

    }

    @DisplayName("注解的反射")
    @Test
    void testAnnatationRelect () {
        Class<User> userClass = User.class;
        Annotation[] annotations = userClass.getAnnotations();
        // 如果存在指定类型的注解，返回注解，否则返回Null
        Token annotation = userClass.getAnnotation(Token.class);
        System.out.println("注解的value：" + annotation.value());
        System.out.println("判断对象是否是注解：" + Token.class.isAnnotation());
        System.out.println("判断类上是否有指定注解：" + userClass.isAnnotationPresent(Token.class));
        System.out.println("判断类上注解的数量：" + annotations.length);
        System.out.println("注解的类全名：" + annotations[0].annotationType().getName());
        System.out.println("注解的类名：" + annotations[0].annotationType().getSimpleName());
    }
}
