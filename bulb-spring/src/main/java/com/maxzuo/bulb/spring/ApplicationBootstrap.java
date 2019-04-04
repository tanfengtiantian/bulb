package com.maxzuo.bulb.spring;

import com.maxzuo.bulb.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 应用启动（Spring standlone container）
 *
 * Created by zfh on 2019/04/04
 */
public class ApplicationBootstrap {

    private static final Lock LOCK = new ReentrantLock();

    private static final Condition STOP = LOCK.newCondition();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        context.start();

        UserService bean = context.getBean(UserService.class);
        System.out.println(bean);

        /// 阻塞
        //Runtime.getRuntime().addShutdownHook(new Thread() {
        //    @Override
        //    public void run() {
        //        try {
        //            LOCK.lock();
        //            STOP.signal();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        } finally {
        //            LOCK.unlock();
        //        }
        //    }
        //});
        //
        //try {
        //    LOCK.lock();
        //    STOP.await();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //} finally {
        //    LOCK.unlock();
        //}
    }
}
