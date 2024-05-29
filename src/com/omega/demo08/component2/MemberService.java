package com.omega.demo08.component2;

import org.springframework.stereotype.Service;

/**
 * Class MemberService
 *
 * @author KennySo
 * @date 2024/5/29
 */
@Service("memberService01")
public class MemberService {

    public void hi() {
        System.out.println("UserService hi()~");
    }
}
