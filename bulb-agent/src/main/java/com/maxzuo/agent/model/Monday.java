package com.maxzuo.agent.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zfh on 2019/03/22
 */
public class Monday {

    private static final Logger logger = LoggerFactory.getLogger(Monday.class);

    private String              number;

    public Monday(String number) {
        logger.info("hello world");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Logger getLogger() {
        return logger;
    }

    public Thuesday getThuesday() {
        return new Thuesday();
    }
}
