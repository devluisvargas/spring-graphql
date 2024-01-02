package com.devluis.springgraphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_authors")
@Getter
@Setter
public class Author {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
