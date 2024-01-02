package com.devluis.springgraphql.service.impl;

import com.devluis.springgraphql.entity.Book;
import com.devluis.springgraphql.repository.BookRepository;
import com.devluis.springgraphql.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        log.info("Saving book with ISBN: {}", book.getIsbn());
        boolean existsBookWithIsbn = this.bookRepository.findById(book.getIsbn()).isPresent();
        if (existsBookWithIsbn) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already a book with isbn code ".concat(book.getIsbn()).concat("."));
        }
        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book get(String isbn) {
        log.info("Fetching book with ISBN: {}", isbn);
        return bookRepository
                .findById(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAll() {
        log.info("Fetching all books");
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        log.info("Updating book with ISBN: {}", isbn);
        this.get(isbn);
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String isbn) {
        log.info("Deleting book with ISBN: {}", isbn);
        Book book = this.get(isbn);
        bookRepository.delete(book);
    }
}
