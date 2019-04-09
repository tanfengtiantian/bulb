package com.maxzuo.agent.annotations;

import java.lang.annotation.*;


/**
 * SPI装载器注解
 * <p>
 * Created by zfh on 2019/04/02
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

    String value() default "";
}
