package com.omega.demo08.component5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class BookService
 *
 * @author KennySo
 * @date 2024/6/21
 */
@Service
public class CarService2 {

    @Value("${brandName}")
    private String brandName;

    @Value("${price}")
    private double price;

    public void print() {
        System.out.println(brandName + " 售价: ￥" + price);
    }
}
