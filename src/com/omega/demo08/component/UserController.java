package com.omega.demo08.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Class UserController
 *
 * @author KennySo
 * @date 2024/5/27
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService01")
    private UserService userService;

    public void say() {
        System.out.println("UserController.userService = " + userService);
        userService.hi();
    }
}
