package com.cdu.A08.dao;

import com.cdu.A08.entity.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id );

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer qurryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer qurryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
