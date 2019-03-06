import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bulb-user-provider
 * Created by MAX_zuo on 2018/09/15
 */
public class DubboProvider {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "classpath:spring-context.xml");
        applicationContext.start();
        com.alibaba.dubbo.container.Main.main(args);
    }

}
