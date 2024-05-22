package com.omega.demo06.test;

import com.omega.demo06.entity.House;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring6Test
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class Spring6Test {

    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("/beans6.xml");

    @Test
    public void testBeanLife() {
        House house1 = ioc.getBean("house1", House.class);
        house1.print();
        House house2 = ioc.getBean("house2", House.class);
        house2.print();

        // 关闭容器才会调用destroy()方法
        // 由于ApplicationContext接口没有close方法, 需要用到它的子类才能使用
        ((ConfigurableApplicationContext) ioc).close();
    }
}
