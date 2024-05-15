package com.omega.demo03.service;

import com.omega.demo03.dao.MemberDAOImpl;

/**
 * Class MemberServiceImpl
 *
 * @author KennySo
 * @date 2024/5/15
 */
public class MemberServiceImpl2 {

    private final MemberDAOImpl memberDAO;

    public MemberServiceImpl2(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void add2() {
        System.out.println("add2方法被调用.");
        memberDAO.insert();
    }
}
