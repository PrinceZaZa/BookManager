package com.cdu.A08.service.impl;

import com.cdu.A08.dao.BookDao;
import com.cdu.A08.dao.OrderDao;
import com.cdu.A08.dao.OrderItemDao;
import com.cdu.A08.dao.impl.BookDaoImpl;
import com.cdu.A08.dao.impl.OrderDaoImpl;
import com.cdu.A08.dao.impl.OrderItemDaoImpl;
import com.cdu.A08.entity.*;
import com.cdu.A08.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wzx
 * @time: 2021/12/11 16:36
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, int userId) {

        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // 保存订单
        orderDao.saveOrder(order);

        System.out.println("OrderServiceImpl中当前线程名："+Thread.currentThread().getName());
        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry :cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        // 清空购物车
        cart.clean();
        return orderId;
    }

    @Override
    public List<OrderItem> orderDetail(String orderId) {

        return orderItemDao.queryOrderDetailByOrderId(orderId);
    }

    @Override
    public List<Order> queryOrder(int useId) {
        return orderDao.queryOrder(useId);
    }

    @Override
    public List<Order> allOrder() {
        return orderDao.queryAllOrder();
    }

    @Override
    public void sendOrder(String orderId) {
        Order order = orderDao.queryOrder(orderId);
        Integer status = order.getStatus();
        if (status==0){
            orderDao.changeOrderStatus(order.getOrderId(),1);
        }
    }

    /**
     * 状态为已发货时，确认收货，改变货品状态
     * @param orderId
     */
    @Override
    public void Receiving(String orderId) {

        Order order = orderDao.queryOrder(orderId);
        Integer status = order.getStatus();
        if (status==1){
            orderDao.changeOrderStatus(order.getOrderId(),2);
        }
    }

    @Override
    public Order queryOrder(String orderId) {
        return orderDao.queryOrder(orderId);
    }
}
