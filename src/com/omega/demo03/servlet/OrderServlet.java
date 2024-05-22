package com.omega.demo03.servlet;

import com.omega.demo03.service.OrderService;

/**
 * Class OrderServlet
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class OrderServlet {

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
