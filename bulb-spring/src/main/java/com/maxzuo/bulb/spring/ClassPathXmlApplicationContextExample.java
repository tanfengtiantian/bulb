package com.maxzuo.bulb.spring;

import com.maxzuo.bulb.spring.model.Token;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 应用启动（Spring standlone container）
 *
 * Created by zfh on 2019/04/04
 */
public class ClassPathXmlApplicationContextExample {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        context.start();

        Token token = context.getBean("getToken", Token.class);
        System.out.println(token);
    }
}
