package com.omega.demo12.test;

import com.omega.demo12.component.SmartAnimal;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring12Test
 *
 * @author KennySo
 * @date 2024/6/10
 */
public class Spring12Test {

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans12.xml");
        SmartAnimal smartAnimal = ioc.getBean(SmartAnimal.class);
        smartAnimal.getSum(100, 88);
    }
}
