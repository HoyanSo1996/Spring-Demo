package com.omega.demo08.component3;

import org.springframework.stereotype.Service;

/**
 * Class AdminServiceImpl
 *
 * @author KennySo
 * @date 2024/5/29
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public void hi() {
        System.out.println("UserServiceImpl hi()~");
    }
}
