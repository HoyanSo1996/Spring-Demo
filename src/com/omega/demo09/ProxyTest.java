package com.omega.demo09;

import com.omega.demo09.entity.Vehicle;
import com.omega.demo09.proxy.Ship;
import com.omega.demo09.proxy2.Car2;
import com.omega.demo09.proxy2.ProxyVehicleFactory;
import com.omega.demo09.proxy3.ProxyFactory;
import com.omega.demo09.proxy3.SmartAnimal;
import com.omega.demo09.proxy3.SmartDog;
import org.junit.jupiter.api.Test;

/**
 * Class ProxyTest
 *
 * @author KennySo
 * @date 2024/5/30
 */
public class ProxyTest {

    /**
     * 使用传统方法调用 car 和 ship 的 run() 方法
     */
    @Test
    public void test1() {
        // Vehicle vehicle = new Car();
        Vehicle vehicle = new Ship();
        vehicle.run();
    }

    /**
     * 使用动态代理模式调用 car 和 ship 的 run() 方法
     */
    @Test
    public void test2() {
        // ProxyVehicleFactory proxyFactory = new ProxyVehicleFactory(new Ship2());
        ProxyVehicleFactory proxyFactory = new ProxyVehicleFactory(new Car2());
        Vehicle proxy = proxyFactory.getProxyVehicle();
        System.out.println("proxy 的编译类型 = Vehicle");
        System.out.println("proxy 的运行类型 = " + proxy.getClass());

        /*
           1. proxy 编译类型是 Vehicle, 所以它可以使用 Vehicle 的方法.
           2. proxy 运行类型是 com.sun.proxy.$Proxy0
           3. 当执行 run() 的时候, 根据Java的动态绑定机制, 这时调用Car的 run(), 实际上是 proxy 对象里 invocationHandler 的 invoke() 方法!!
           4. invoke() 方法使用反射机制来调用真正的 run() 方法, 这个方法也可以是 Vehicle 的其它方法.
           5. 也就是说任一类实现了 Vehicle 接口, 就可以放入 proxyFactory 类中, 得到的代理类调用的方法, 是动态的变化的
         */
        proxy.run();
    }


    @Test
    public void testSmartDog() {
        ProxyFactory<SmartAnimal> smartAnimalProxyFactory = new ProxyFactory<>(new SmartDog());
        SmartAnimal proxyInstance = smartAnimalProxyFactory.getProxyInstance();
        proxyInstance.getSum(10, 2);
        System.out.println("====================================");
        proxyInstance.getSub(10, 2);
    }
}
