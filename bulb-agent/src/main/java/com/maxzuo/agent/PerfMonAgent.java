package com.maxzuo.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * Agent探针入口
 * Created by zfh on 2019/01/30
 */
public class PerfMonAgent {

    /**
     * 运行Main.class前，启动探针：
     *   java "-javaagent:F:\bulb\bulb-agent\target\bulb-agent-jar-with-dependencies.jar" -Dfile.encoding=UTF-8 -classpath F:\bulb\bulb-demo\target\classes com.maxzuo.agent.Main
     * 运行jar前，启动探针：
     *   java "-javaagent:F:\bulb\bulb-agent\target\bulb-agent-jar-with-dependencies.jar" -Dfile.encoding=UTF-8 -jar F:\bulb\spring-boot-app\target\spring-boot-app.jar
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("========进入premain方法============");
        System.out.println("getClassLoader(): " + PerfMonAgent.class.getClassLoader());
        System.out.println("getContextClassLoader()：" + Thread.currentThread().getContextClassLoader());

        new AgentBuilder.Default()
            .type(ElementMatchers.isAnnotation()).transform(new AgentBuilder.Transformer() {
                @Override
                public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder,
                                                        TypeDescription typeDescription, ClassLoader classLoader,
                                                        JavaModule module) {
                    System.out.println("typeDescription: " + typeDescription);
                    //System.out.println("classLoader: " + classLoader);
                    //System.out.println("module: " + module);

                    /// 篡改字节码文件
                    //builder = builder.defineField("name", String.class, Visibility.PUBLIC);
                    //FileUtils.writeToFile(builder.make().getBytes());

                    return builder;
                }
            }).installOn(inst);
    }

}
