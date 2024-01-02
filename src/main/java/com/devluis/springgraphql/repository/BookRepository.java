package com.devluis.springgraphql.repository;

import com.devluis.springgraphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
