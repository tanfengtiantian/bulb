import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bulb-order-provider
 * Created by MAX_zuo on 2018/09/15
 */
public class DubboBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "classpath:spring/spring-context.xml");
        applicationContext.start();
        com.alibaba.dubbo.container.Main.main(args);
    }

}
