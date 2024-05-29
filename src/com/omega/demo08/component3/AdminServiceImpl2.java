package com.omega.demo08.component3;

import org.springframework.stereotype.Service;

/**
 * Class AdminServiceImpl2
 *
 * @author KennySo
 * @date 2024/5/29
 */
@Service
public class AdminServiceImpl2 implements AdminService {

    @Override
    public void hi() {
        System.out.println("UserServiceImpl2 hi()~");
    }
}
