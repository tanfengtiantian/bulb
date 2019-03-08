package com.maxzuo.bulb.exception.common;

import com.maxzuo.bulb.exception.BaseException;

/**
 * 参数错误异常
 * Created by zfh on 2019/3/7
 */
public class ParamterErrorException extends BaseException {

    private static final long serialVersionUID = -630472067126208283L;

    public ParamterErrorException() {
        super("00002", "参数错误！");
    }
}
