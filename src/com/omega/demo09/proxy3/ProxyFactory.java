package com.omega.demo09.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Class ProxyFactory
 *
 * @author KennySo
 * @date 2024/6/1
 */
public class ProxyFactory<T> {

    private T targetInstance;

    public ProxyFactory(T targetInstance) {
        this.targetInstance = targetInstance;
    }

    public T getProxyInstance() {
        ClassLoader classLoader = this.targetInstance.getClass().getClassLoader();
        Class<?>[] interfaces = this.targetInstance.getClass().getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> {
            Object result = null;
            try {
                AOPUtils.before(proxy, method, args);
                result = method.invoke(targetInstance, args);
                AOPUtils.after(proxy, method, args, (Double) result);
            } catch (Exception e) {
                AOPUtils.error(proxy, method, args, e);
            } finally {
                AOPUtils.finalize(proxy, method, args);
            }
            return result;
        };

        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (T) proxyInstance;
    }
}
