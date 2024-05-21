package com.omega.demo05.service;

import com.omega.demo05.dao.MemberDAOImpl;

/**
 * Class MemberServiceImpl
 *
 * @author KennySo
 * @date 2024/5/21
 */
public class MemberServiceImpl {

    private MemberDAOImpl memberDAO;

    private String service;

    public MemberServiceImpl() {
        System.out.println("MemberServiceImpl() 构造器...");
        System.out.println("service = " + service);
        System.out.println("memberDAO = " + memberDAO);
    }

    public MemberServiceImpl(MemberDAOImpl memberDAO, String service) {
        this.memberDAO = memberDAO;
        this.service = service;
        System.out.println("MemberServiceImpl() 有参构造器...");
        System.out.println("service = " + service);
        System.out.println("memberDAO = " + memberDAO);
    }

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void addMember() {
        memberDAO.insert();
    }
}