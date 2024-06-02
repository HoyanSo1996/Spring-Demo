package com.omega.demo10.component;

import org.springframework.stereotype.Component;

/**
 * Class SmartDog
 *
 * @author KennySo
 * @date 2024/6/1
 */
@Component
public class SmartDog implements SmartAnimal {

    @Override
    public double getSum(double num1, double num2) {
        double result = num1 + num2;
        // int i = 10 / 0;
        System.out.println("方法内部打印 result = " + result);
        return result;
    }

    @Override
    public double getSub(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("方法内部打印 result = " + result);
        return result;
    }
}
