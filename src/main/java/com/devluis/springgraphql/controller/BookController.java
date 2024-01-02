package com.devluis.springgraphql.controller;

import com.devluis.springgraphql.entity.Book;
import com.devluis.springgraphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @MutationMapping
    public Book createBook(@Argument Book book) {
        return bookService.save(book);
    }

    @QueryMapping
    public Book getBook(@Argument String isbn) {
        return bookService.get(isbn);
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @MutationMapping
    public Book updateBook(@Argument String isbn, @Argument Book book) {
        return bookService.updateBook(isbn, book);
    }

    @MutationMapping
    public void deleteBook(@Argument String isbn) {
        bookService.deleteBook(isbn);
    }
}
