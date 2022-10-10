package com.cdu.A08.dao.impl;

import com.cdu.A08.dao.OrderDao;
import com.cdu.A08.dao.impl.BaseDao;
import com.cdu.A08.entity.Order;

import java.util.List;

/**
 * @description:
 * @author: wzx
 * @time: 2021/12/11 16:17
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) " +
                "values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrder(int userId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `user_id`=?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public int changeOrderStatus(String orderId, int status) {
        String sql="update t_order set `status`=? where order_id=?";
        return update(sql,status,orderId);
    }

    @Override
    public Order queryOrder(String orderId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `order_id`=?";
        return queryForOne(Order.class,sql,orderId);
    }

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class,sql);
    }
}
