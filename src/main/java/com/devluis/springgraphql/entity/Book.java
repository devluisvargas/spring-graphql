package com.devluis.springgraphql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_books")
@Getter @Setter
public class Book {
    @Id
    private String isbn;

    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
