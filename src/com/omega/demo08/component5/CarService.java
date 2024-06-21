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
public class CarService {

    @Value("奥迪")
    private String brandName;

    @Value("290000.00")
    private double price;

    public void print() {
        System.out.println(brandName + " 售价: ￥" + price);
    }
}
