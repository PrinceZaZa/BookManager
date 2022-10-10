package com.cdu.A08.controller;

import com.cdu.A08.entity.Book;
import com.cdu.A08.entity.Page;
import com.cdu.A08.service.BookService;
import com.cdu.A08.service.impl.BookServiceImpl;
import com.cdu.A08.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize)：page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");
        //3、保存Page对象到Request域中
        req.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //  1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // 2、调用BookService.addBook()保存图书
        bookService.addBook(book);
        // 3、跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        //3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成为book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用bookService.updateBook() 修改图书信息
        bookService.updateBook(book);
        //3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.qurryBooks();
        //2 把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.deleteBookById();删除图书
        Book book = bookService.quryBookById(id);
        //3.保存图书到request域中
        req.setAttribute("book", book);

        //4.请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

}
