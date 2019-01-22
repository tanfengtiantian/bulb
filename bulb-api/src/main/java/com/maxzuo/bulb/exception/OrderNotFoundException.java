package com.maxzuo.bulb.exception;

/**
 * 订单不存在异常
 * Created by zfh on 2019/01/19
 */
public class OrderNotFoundException extends BaseException {

    private static final long serialVersionUID = 7759716985741965901L;

    OrderNotFoundException() {
        super("10002", "订单没有找到！");
    }
}
