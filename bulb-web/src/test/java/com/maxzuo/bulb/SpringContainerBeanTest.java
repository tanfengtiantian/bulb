package com.maxzuo.bulb;

import org.junit.Test;

/**
 * 探索Spring父子容器
 * Created by zfh on 2019/01/21
 */
public class SpringContainerBeanTest {

    /**
     * 问题：Spring的IOC容器和SpringMVC的IOC容器扫描的包有重合的部分，就会导致Bean在两个容器中分别创建一次
     * <context:component-scan base-package="com.maxzuo">
     *     <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
     * </context:component-scan>
     * 以上配置表示容器中排除了对 @Controller注解的扫描，因此该注解的Bean不会注入到容器中。
     * 注解 @Autowired  com.maxzuo.controller.Rest; 就会因为无法找到Bean，发生异常。
     */
    @Test
    public void testContainerBuildBean() {
        /*
            @Autowired
            private Rest rest;
            System.out.println("rest: " + rest);
         */
    }

    /**
     * 探索Spring MVC WEB容器可以作为“业务层”Spring IOC容器的子容器：即WEB层容器可以引用业务层容器的Bean，
     * 而业务层容器却访问不到WEB层容器的Bean。
     */
    @Test
    public void testMultipleComtainerAccessBean () {
        // TODO: 参见 腾讯文档 https://docs.qq.com/doc/DWnVHU3pEYVVZcVRn?opendocxfrom=admin
    }
}
