package com.omega.demo03.service;

import com.omega.demo03.dao.OrderDAO;

/**
 * Class OrderService
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class OrderService {

    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
