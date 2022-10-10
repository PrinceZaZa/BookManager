package com.cdu.A08.service;

import com.cdu.A08.entity.Cart;
import com.cdu.A08.entity.Order;
import com.cdu.A08.entity.OrderItem;

import java.util.List;

/**
 * @description:
 * @author: wzx
 * @time: 2021/12/11 16:34
 */
public interface OrderService {

    /**
     * 创建订单
     * @param cart 用于创建订单的购物车
     * @param userId 创建这个订单的用户id
     * @return
     */
    String createOrder(Cart cart, int userId);


    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItem> orderDetail(String orderId);

    /**
     * 查看指定用户订单
     * @param useId
     * @return
     */
    List<Order> queryOrder(int useId);

    /**
     * 查看所有订单
     * @return
     */
    List<Order> allOrder();

    /**
     * 订单发货
     * @param orderId
     */
    void sendOrder(String orderId);


    /**
     * 收货订单
     * @param orderId
     */
    void Receiving(String orderId);


    /**
     * 根据订单号查找订单
     * @param orderId
     * @return
     */
    Order queryOrder(String orderId);
}
