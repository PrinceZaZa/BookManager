package com.cdu.A08.dao;

import com.cdu.A08.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    List<OrderItem> queryOrderDetailByOrderId(String orderId);
}
