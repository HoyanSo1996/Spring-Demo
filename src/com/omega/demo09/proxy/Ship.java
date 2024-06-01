package com.omega.demo09.proxy;

import com.omega.demo09.entity.Vehicle;

/**
 * Class Ship
 *
 * @author KennySo
 * @date 2024/5/31
 */
public class Ship implements Vehicle {

    @Override
    public void run() {
        System.out.println("交通工具开始运行了...");
        System.out.println("小船在水里 running...");
        System.out.println("交通工具停止运行了...");
    }
}
