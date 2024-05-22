package com.omega.demo06.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Class Dog
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class Dog implements InitializingBean, DisposableBean {

    private String name;

    public void setName(String name) {
        System.out.println(name + " setName() 方法...");
        this.name = name;
    }

    /**
     * 初始化方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " init() ...");
    }

    /**
     * 销毁后方法
     */
    @Override
    public void destroy() throws Exception {
        System.out.println(name + " destroy() ...");
    }

    public void bark() {
        System.out.println(name + " 汪汪叫...");
    }
}
