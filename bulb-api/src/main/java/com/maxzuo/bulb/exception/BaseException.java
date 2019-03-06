package com.maxzuo.bulb.exception;

/**
 * 统一异常处理-异常基类
 * Created by zfh on 2019/01/19
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1397997744978096749L;

    private String            errCode;

    private String            errMessage;

    BaseException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    BaseException(String errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
