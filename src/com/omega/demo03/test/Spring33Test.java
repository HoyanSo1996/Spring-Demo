package com.omega.demo03.test;

import com.omega.demo03.entity.SpringELBean;
import com.omega.demo03.servlet.OrderServlet;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring33Test
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class Spring33Test {

    private final ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("/beans3.xml");

    /**
     * 通过 自动装配 方式注入值
     */
    @Test
    public void setBeanPropertiesByAutowire() {
        OrderServlet orderServlet = ioc.getBean("orderServlet", OrderServlet.class);
        orderServlet.getOrderService().getOrderDAO().saveOrder();
    }

    /**
     * 通过 SpringEL 方式注入值
     */
    @Test
    public void setBeanPropertiesBySpringEL() {
        SpringELBean springELBean = ioc.getBean("springELBean", SpringELBean.class);
        System.out.println(springELBean);
    }
}
