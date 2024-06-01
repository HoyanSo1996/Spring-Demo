package com.omega.demo09.proxy2;

import com.omega.demo09.entity.Vehicle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Class ProxyFactory
 *
 * @author KennySo
 * @date 2024/5/31
 */
public class ProxyVehicleFactory {

    // 设置一个目标对象, 它需要实现Vehicle接口
    private Vehicle targetVehicle;

    public ProxyVehicleFactory(Vehicle vehicle) {
        this.targetVehicle = vehicle;
    }

    public Vehicle getProxyVehicle() {
        // 1.获取classloader
        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();
        // 2.获取接口类型数组
        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();
        // 3.创建InvocationHandler对象
        //   重写invoke方法, 在这里构建代理对象的方法
        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             * invoke() 方法 是 代理对象 对 目标对象 任一方法的增强方法
             * @param proxy 代理对象
             * @param method 目标对象 的方法
             * @param args 目标对象 方法的参数
             * @return 目标对象 方法的返回值
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了...");
                Object result = method.invoke(targetVehicle, args);
                System.out.println("交通工具停止运行了...");
                return result;
            }
        };

        /**
         * Proxy.newProxyInstance() 可以返回一个代理对象
         * @param ClassLoader loader : 目标对象的类加载器
         * @param Class<?>[] interfaces : 目标对象的接口信息
         * @param InvocationHandler h : 调用处理器, 用来增强目标对象的方法
         * @return 代理对象
         */
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (Vehicle) proxy;
    }
}
