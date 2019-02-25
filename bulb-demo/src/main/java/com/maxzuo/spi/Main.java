package com.maxzuo.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

/**
 * Java之SPI机制
 * Created by zfh on 2019/02/07
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<IDeveloper> serviceLoader = ServiceLoader.load(IDeveloper.class);
        for (IDeveloper developer : serviceLoader) {
            developer.say();
        }
    }

    private void test () throws ClassNotFoundException, SQLException {
        /// 加载Class到classLoader
        //Class.forName("com.mysql.jdbc.Driver");

        // 通过java库获取数据库连接
        Connection connection = DriverManager.getConnection("", "", "");
    }
}
