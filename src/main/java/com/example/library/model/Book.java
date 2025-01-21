package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;



import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(String title, int publicationYear) {
        this.title=title;
        this.publicationYear=publicationYear;
    }

    public Book() {

    }
}
