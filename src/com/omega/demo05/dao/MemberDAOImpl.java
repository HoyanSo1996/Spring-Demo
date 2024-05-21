package com.omega.demo05.dao;

/**
 * Class MemberDao
 *
 * @author KennySo
 * @date 2024/5/21
 */
public class MemberDAOImpl {

    private String dao;

    public MemberDAOImpl() {
        System.out.println("MemberDAOImpl() 构造器...");
        System.out.println("dao = " + dao);
    }

    public MemberDAOImpl(String dao) {
        this.dao = dao;
        System.out.println("MemberDAOImpl() 有参构造器...");
        System.out.println("dao = " + dao);
    }

    public void setDao(String dao) {
        this.dao = dao;
    }

    public void insert() {
        System.out.println("添加一个会员");
    }
}