package com.omega.demo11.component;

import org.springframework.stereotype.Component;

/**
 * Class Ship
 *
 * @author KennySo
 * @date 2024/6/9
 */
@Component
public class Ship {

    public void run() {
        System.out.println("ship is voyaging.");
    }

    public String run(double miles) {
        // int i = 1 / 0;
        return "ship have voyaged for " + miles + " miles.";
    }

    public String run(double miles, int day) {
        // int i = 1 / 0;
        return "ship have voyaged for " + miles + " miles in " + day + "s.";
    }
}
