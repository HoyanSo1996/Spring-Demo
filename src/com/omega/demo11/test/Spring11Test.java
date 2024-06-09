package com.omega.demo11.test;

import com.omega.demo11.component.Ship;
import com.omega.demo11.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class Spring11Test
 *
 * @author KennySo
 * @date 2024/6/9
 */
public class Spring11Test {

    private final ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

    /**
     * 获取 目标方法 的相关信息
     */
    @Test
    public void testShip() {
        Ship ship = ioc.getBean(Ship.class);
        ship.run();
    }

    @Test
    public void testShipAfterReturning() {
        Ship ship = ioc.getBean(Ship.class);
        ship.run(100);
    }

    @Test
    public void testShipDoAround() {
        Ship ship = ioc.getBean(Ship.class);
        ship.run(120, 2);
    }
}
