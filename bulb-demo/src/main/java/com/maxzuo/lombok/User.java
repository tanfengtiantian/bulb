package com.maxzuo.lombok;

import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

/**
 * Created by zfh on 2019/02/12
 */
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String name;

    private Integer age;
}
