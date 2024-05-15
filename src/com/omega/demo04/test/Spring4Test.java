package com.omega.demo04.test;

import com.omega.entity.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring4Test
 *
 * @author KennySo
 * @date 2024/5/15
 */
public class Spring4Test {

    private final static ApplicationContext ioc = new ClassPathXmlApplicationContext("/beans4.xml");

    /**
     * 通过 静态工厂 获取 bean
     */
    @Test
    public void testGetBeanByStaticFactory() {
        Monster monster1 = ioc.getBean("monster01", Monster.class);
        System.out.println(monster1);
        Monster monster11 = ioc.getBean("monster01", Monster.class);
        System.out.println(monster1 == monster11);  // 无论获取几次, 在里面获取的对象是同一个
    }

    /**
     * 通过 实例工厂 获取 bean
     */
    @Test
    public void testGetBeanByInstanceFactory() {
        Monster monster02 = ioc.getBean("monster02", Monster.class);
        System.out.println(monster02);

        Monster monster022 = ioc.getBean("monster02", Monster.class);
        System.out.println(monster02 == monster022);  // true, 由于是同一个实例工厂获取的bean, 所以获取的bean是同一个

        Monster monster03 = ioc.getBean("monster03", Monster.class);
        System.out.println(monster02 == monster03);  // false, 由于是两个实例工厂, 所以获取的bean不是同一个
    }

    /**
     * 通过 factoryBean 获取 bean
     */
    @Test
    public void testGetBeanByFactoryBean() {
        Monster monster = ioc.getBean("monsterFactoryBean", Monster.class);
        System.out.println(monster);
    }
}
