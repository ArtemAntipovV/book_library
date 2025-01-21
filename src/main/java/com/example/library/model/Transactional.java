package com.example.library.model;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "transactional")
@Data
public class Transactional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_type", nullable = false)
    private String operationType;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    private Reader reader;

    @ManyToOne
    private Book book;

    public Transactional(Book book, LocalDateTime dateTime, String operationType, Reader reader) {
        this.operationType = operationType;
        this.dateTime = dateTime;
        this.reader = reader;
        this.book = book;
    }

    public Transactional() {

    }
}
