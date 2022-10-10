package com.cdu.A08.dao;

import com.cdu.A08.entity.Order;

import java.util.List;

/**
 * @description:
 * @author: wzx
 * @time: 2021/12/11 16:11
 */
public interface OrderDao {

    /**
     * 生成保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 根据用户id查询所有订单
     * @param userId
     * @return
     */
    List<Order> queryOrder(int userId);

    /**
     * 修改订单状态
     * @param orderId 要修改的订单的id
     * @param status  要修改的订单状态, 0未发货, 1已发货, 2已收货
     * @return 受影响的行数
     */
    int changeOrderStatus(String orderId, int status);

    /**
     * 根据订单号查找订单
     * @param orderId
     * @return
     */
    Order queryOrder(String orderId);

    /**
     * 查看所有的订单
     * @return
     */
    List<Order> queryAllOrder();
}
