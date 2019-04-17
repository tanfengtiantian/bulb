package com.maxzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zfh on 2018/09/18
 */
@SpringBootApplication
public class AppApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许的路径
        registry.addMapping("/**")
        // 允许的域名
            .allowedOrigins("*")
            // 允许证书
            .allowCredentials(true)
            // 允许的请求类型
            .allowedMethods("GET", "POST")
            // 允许的头部
            .allowedHeaders("token", "Origin", "X-Requested-With", "Content-Type", "Accept");
    }
}
