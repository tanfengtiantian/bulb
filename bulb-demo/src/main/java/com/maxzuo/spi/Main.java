package com.maxzuo.spi;

import java.util.ServiceLoader;

/**
 * Java之SPI机制
 * Created by zfh on 2019/02/07
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<IDeveloper> serviceLoader = ServiceLoader.load(IDeveloper.class);
        for (IDeveloper developer : serviceLoader) {
            String programe = developer.getPrograme();
            System.out.println("out: " + programe);
        }
    }
}
