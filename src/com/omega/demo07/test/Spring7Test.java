package com.omega.demo07.test;

import com.omega.demo07.component.MyComponent;
import com.omega.demo07.component.UserDAO;
import com.omega.demo07.component.UserService;
import com.omega.demo07.component.UserServlet;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring7Test
 *
 * @author KennySo
 * @date 2024/5/27
 */
public class Spring7Test {

    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans7.xml");

    @Test
    public void getBeanByAnnotation() {
        UserServlet userServlet = ioc.getBean(UserServlet.class);
        UserService userService = ioc.getBean(UserService.class);
        UserDAO userDAO = ioc.getBean(UserDAO.class);
        MyComponent myComponent = ioc.getBean(MyComponent.class);

        System.out.println("userServlet = " + userServlet);
        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);
        System.out.println("myComponent = " + myComponent);
    }
}
