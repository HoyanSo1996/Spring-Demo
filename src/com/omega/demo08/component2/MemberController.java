package com.omega.demo08.component2;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Class MemberController
 *
 * @author KennySo
 * @date 2024/5/29
 */
@Controller
public class MemberController {

    @Resource(name = "memberService01", type = MemberService.class)
    private MemberService memberService;

    public void say() {
        System.out.println("MemberController.memberService = " + memberService);
        memberService.hi();
    }
}
