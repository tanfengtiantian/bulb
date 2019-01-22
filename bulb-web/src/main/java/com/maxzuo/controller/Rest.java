package com.maxzuo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfh on 2018/09/19
 */
@RestController
@RequestMapping("rest")
public class Rest {

    @GetMapping("main")
    public String main () {
        return "main rest";
    }
}
