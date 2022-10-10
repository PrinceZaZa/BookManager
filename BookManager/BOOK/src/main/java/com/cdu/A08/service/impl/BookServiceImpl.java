package com.cdu.A08.service.impl;

import com.cdu.A08.dao.BookDao;
import com.cdu.A08.dao.impl.BookDaoImpl;
import com.cdu.A08.entity.Book;
import com.cdu.A08.entity.Page;
import com.cdu.A08.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    //连接数据库
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book quryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> qurryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.qurryForPageTotalCount();

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        //设置总页码
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);

        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.qurryForPageTotalCountByPrice(min,max);

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        //设置总页码
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);

        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
