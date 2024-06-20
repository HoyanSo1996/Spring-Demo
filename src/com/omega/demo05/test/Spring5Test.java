package com.omega.demo05.test;

import com.omega.demo05.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring5Test
 *
 * @author KennySo
 * @date 2024/5/21
 */
public class Spring5Test {

    @Test
    public void testCreateBeanOrder() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans5.xml");
        MemberServiceImpl memberService = ioc.getBean("memberService", MemberServiceImpl.class);
        memberService.addMember();
    }
}
