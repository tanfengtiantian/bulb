package com.maxzuo.controller;

import com.maxzuo.bulb.api.IUserService;
import com.maxzuo.bulb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfh on 2018/09/19
 */
@RestController
@RequestMapping("rest")
public class Rest {

    @Autowired
    private IUserService userService;

    @GetMapping("main")
    public String main() {
        User userInfo = userService.getByPrimaryKey(3);
        System.out.println("userInfo: " + userInfo);
        return "main rest";
    }
}
