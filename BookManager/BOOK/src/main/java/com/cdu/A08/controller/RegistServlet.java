package com.cdu.A08.controller;


import com.cdu.A08.entity.User;
import com.cdu.A08.service.UserService;
import com.cdu.A08.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查 验证码是否正确。先写死，abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //正确
            //检查用户名是否可用
            if (userService.existsUsername(username)) {

                //不可用
                System.out.println("用户名已存在！");

                //把回显信息保存到request域中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //从新加载注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            } else {
                //可用 调用service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }

        } else {

            //把回显信息保存到request域中
            req.setAttribute("msg","验证码有误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            //不正确 跳回注册页面
            System.out.println("验证码【" + code + "】错误");
            //回到注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }
}
