package com.cdu.A08.service;

import com.cdu.A08.entity.Book;
import com.cdu.A08.entity.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book quryBookById(Integer id);

    public List<Book> qurryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
