package com.omega.demo10.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Class CarAspect
 *
 * @author KennySo
 * @date 2024/6/6
 */
@Component
@Aspect
public class CarAspect {

    @Before("execution(public void com.omega.demo10.component.Car.run())")
    public void enhance() {
        System.out.println("add flying feature.");
    }
}
