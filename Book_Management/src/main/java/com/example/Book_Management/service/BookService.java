package com.example.Book_Management.service;

import com.example.Book_Management.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBookById(Long id);
}
