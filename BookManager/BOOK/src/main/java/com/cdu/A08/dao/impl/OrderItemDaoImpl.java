package com.cdu.A08.dao.impl;

import com.cdu.A08.dao.OrderItemDao;
import com.cdu.A08.entity.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderDetailByOrderId(String orderId) {
        String sql = "select id,`name`,`count`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
