package com.omega.demo10.test;

import com.omega.demo10.component.Car;
import com.omega.demo10.component.SmartAnimal;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring10Test
 *
 * @author KennySo
 * @date 2024/6/2
 */
public class Spring10Test {

    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("/beans10.xml");

    /*
        smartAnimal 的运行类型是 class com.sun.proxy.$Proxy19
        在 singletonObjects 中, value 中存储的是 smartDog 类型, 但是在使用 getBean() 的过程中，
        才使用了动态代理, 将获取到的结果变成 Proxy 类.
     */
    @Test
    public void testSmartDogByAop() {
        SmartAnimal smartAnimal = ioc.getBean(SmartAnimal.class);
        smartAnimal.getSum(10, 2);

        System.out.println("smartAnimal 的编译类型 = SmartAnimal");
        System.out.println("smartAnimal 的运行类型 = " + smartAnimal.getClass());

        // 不能通过 SmartDog 类获取 Bean, 会报异常
        // SmartDog smartDog = ioc.getBean(SmartDog.class);
        // System.out.println("smartDog2 的运行类型 = " + smartDog.getClass());

        // 可以使用 id 获取 Bean, 但获取的类型依然为 Proxy 类
        Object smartDog2 = ioc.getBean("smartDog");
        System.out.println("smartDog2 的运行类型 = " + smartDog2.getClass());
    }


    /**
     * 测试 SpringGCLIB 动态代理
     * (即为没有接口的类创建代理对象)
     */
    @Test
    public void testCar() {
        Car car = ioc.getBean(Car.class);
        car.run();
        // car 的运行类型 = Car$$EnhancerBySpringCGLIB$$7b933c74
        System.out.println("car的运行类型" + car.getClass());
    }
}
