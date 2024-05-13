package com.omega.demo01.test;

import com.omega.entity.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class SpringTest
 *
 * @author KennySo
 * @date 2024/5/14
 */
public class SpringTest {

    @Test
    public void testGetBean() {
        // 1.创建ioc容器, 容器与配置文件关联(可以有多个配置文件)
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        // 2.通过getBean获取对应的对象
        // 使用id来获取bean
        // 弊端：如果只使用id来获取bean, 那么需要自己手动强转类型
        Object monster01 = ioc.getBean("monster01");
        System.out.println("monster01 = " + monster01);
        System.out.println("运行类型 = " + monster01.getClass());

        // 使用class来获取bean
        // 弊端：不能在xml文件里配置多个同类型的bean, 否则会抛出异常.
        Monster monster011 = ioc.getBean(Monster.class);
        System.out.println("monster011 = " + monster011);

        // 如果使用id + class来获取bean, 则可以不用自己转类型
        Monster monster0111 = ioc.getBean("monster01", Monster.class);
        System.out.println("monster0111 = " + monster0111);
    }
}
