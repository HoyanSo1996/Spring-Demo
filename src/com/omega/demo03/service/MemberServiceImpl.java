package com.omega.demo03.service;

import com.omega.demo03.dao.MemberDAOImpl;

/**
 * Class MemberServiceImpl
 *
 * @author KennySo
 * @date 2024/5/15
 */
public class MemberServiceImpl {

    private MemberDAOImpl memberDAO;

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void add() {
        System.out.println("add方法被调用.");
        memberDAO.insert();
    }
}
