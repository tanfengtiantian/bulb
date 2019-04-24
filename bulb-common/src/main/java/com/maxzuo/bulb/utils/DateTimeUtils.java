package com.maxzuo.bulb.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间日期工具类（JDK8日期API 线程安全）
 * Created by zfh on 2019/03/14
 */
public class DateTimeUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);

    /** 解析格式 */
    private static final String FORMATTER_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化成字符串
     */
    public static String dateTimeToString (LocalDateTime dateTime, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = FORMATTER_PATTERN;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        try {
            return dateTime.format(dtf);
        } catch (Exception e) {
            logger.info("解析日期异常", e);
        }
        return null;
    }

    /**
     * Date转换为时间字符串，使用默认格式
     */
    public static String dateToString (Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return dateTimeToString(localDateTime);
    }

    /**
     * Date转换为时间字符串，自定义格式
     */
    public static String dateToString (Date date, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dtf);
    }

    /**
     * LocalDateTime转换为时间字符串，使用默认格式
     */
    public static String dateTimeToString (LocalDateTime dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
        try {
            return dateTime.format(dtf);
        } catch (Exception e) {
            logger.info("解析日期异常", e);
        }
        return null;
    }

    /**
     * 字符串解析成日期
     */
    public static LocalDateTime stringToDateTime (String dateTimeStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
        try {
            return LocalDateTime.parse(dateTimeStr, dtf);
        } catch (Exception e) {
            logger.info("解析日期异常", e);
        }
        return null;
    }

    public static LocalDateTime stringToDateTime (String dateTimeStr, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = FORMATTER_PATTERN;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(dateTimeStr, dtf);
        } catch (Exception e) {
            logger.info("解析日期异常", e);
        }
        return null;
    }
}
