package com.omega.demo06.entity;

/**
 * Class House
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class House {

    private String name;

    public House() {
        System.out.println("House() 构造器...");
    }

    public void setName(String name) {
        System.out.println(name + " setName() 方法...");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 初始化和销毁方法的 方法名 的名由程序员自己命名
    public void init() {
        System.out.println(name + " init() 方法...");
    }

    public void destroy() {
        System.out.println(name + " destroy() 方法...");
    }

    public void print() {
        System.out.println(name + " print() 方法...");
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                '}';
    }
}
