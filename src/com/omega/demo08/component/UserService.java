package com.omega.demo08.component;

import org.springframework.stereotype.Service;

/**
 * Class UserService
 *
 * @author KennySo
 * @date 2024/5/27
 */
@Service("userService01")
public class UserService {

    public void hi(){
        System.out.println("UserService hi()~");
    }
}
