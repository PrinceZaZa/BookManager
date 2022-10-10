package com.cdu.A08.controller;

import com.cdu.A08.entity.Cart;
import com.cdu.A08.entity.Order;
import com.cdu.A08.entity.OrderItem;
import com.cdu.A08.entity.User;
import com.cdu.A08.service.OrderService;
import com.cdu.A08.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("OrderServlet中当前线程名：" + Thread.currentThread().getName());

        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userId
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
        //调用 orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, id);


        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()
                + "/pages/cart/checkout.jsp");
    }

    protected void queryOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取用户id
        User user = (User) req.getSession().getAttribute("user");

        //获取订单
        List<Order> orders = orderService.queryOrder(user.getId());

        //将订单信息存入Request域
        req.setAttribute("orders", orders);

        //转发到页面列表页面: /pages/order/order.jsp
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void orderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取订单号
        String orderId = req.getParameter("orderId");

        //查找订单与订单项
        Order order = orderService.queryOrder(orderId);
        List<OrderItem> orderItems = orderService.orderDetail(orderId);

        req.setAttribute("order", order);
        req.setAttribute("orderItems", orderItems);
        //转发到订单详情页面: /pages/order/order_detail.jsp
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }

    protected void orderReceive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取订单号
        String orderId = req.getParameter("orderId");

        //确认收获
        orderService.Receiving(orderId);

        //重定向到订单详情页
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=orderDetail&orderId=" + orderId);
    }

    protected void orderSend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        //点击发货
        orderService.sendOrder(orderId);
        //重定向到订单详情页
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=allOrder");
    }

    protected void allOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取所有的订单信息
        List<Order> orders = orderService.allOrder();

        //保存到request域中
        req.setAttribute("orders",orders);

        //3、请求转发到/pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
}