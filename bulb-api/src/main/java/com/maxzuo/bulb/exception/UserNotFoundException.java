package com.maxzuo.bulb.exception;

/**
 * 用户账户不存在异常
 * Created by zfh on 2019/01/19
 */
public class UserNotFoundException extends BaseException {

    private static final long serialVersionUID = 104911104017765552L;

    UserNotFoundException() {
        super("10001", "用户不存在！");
    }
}
