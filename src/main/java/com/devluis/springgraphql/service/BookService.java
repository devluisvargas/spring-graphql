package com.devluis.springgraphql.service;

import com.devluis.springgraphql.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Book get(String isbn);
    List<Book> getAll();
    Book updateBook(String isbn, Book book);
    void deleteBook(String isbn);
}
