package com.maxzuo.bulb.spring;

import com.maxzuo.bulb.spring.model.Token;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p> @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
 *
 * Created by zfh on 2019/04/04
 */
public class AnnotationConfigApplicationContextExample {

    public static void main(String[] args) {
        /// 扫描指定的类
        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationAnnotationExample.class);

        // 扫描包路径
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.maxzuo.bulb.spring");

        Token bean = applicationContext.getBean(Token.class);
        System.out.println(bean);
    }
}
