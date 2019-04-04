package com.maxzuo.bulb.spring;

import com.maxzuo.bulb.spring.model.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zfh on 2019/04/04
 */
public class BeanFactoryExample {

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("spring-context.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        User bean = xmlBeanFactory.getBean(User.class);
        System.out.println(bean);
    }
}
