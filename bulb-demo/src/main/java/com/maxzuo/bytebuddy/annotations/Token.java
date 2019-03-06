package com.maxzuo.bytebuddy.annotations;

import java.lang.annotation.*;
import java.lang.annotation.Target;

/**
 * Created by zfh on 2019/02/13
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.FIELD })
public @interface Token {
}
