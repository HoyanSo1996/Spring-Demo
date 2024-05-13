package com.omega.demo00.test;

import com.omega.demo00.ioc.CustomApplicationContext;

/**
 * Class Test
 *
 * @author KennySo
 * @date 2024/5/14
 */
public class Test {

    public static void main(String[] args) {
        try {
            CustomApplicationContext customApplicationContext = new CustomApplicationContext("beans.xml");
            // 从IOC容器中获取bean
            Object monster01 = customApplicationContext.getBean("monster01");
            System.out.println(monster01);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

