package com.example.library.config;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Reader;
import com.example.library.model.Transactional;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TransactionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class DataLoader  {
//
//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//    private final ReaderRepository readerRepository;
//    private final TransactionalRepository transactionalRepository;
//
//    public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository,
//                      ReaderRepository readerRepository, TransactionalRepository transactionalRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//        this.readerRepository = readerRepository;
//        this.transactionalRepository = transactionalRepository;
//    }
//
//    public void run(String... args) throws Exception {
//        // Добавление авторов
//        Author author1 = new Author("John", "Doe", LocalDate.of(1980, 5, 15));
//        Author author2 = new Author("Jane", "Smith", LocalDate.of(1990, 9, 10));
//        Author author3 = new Author("Michael", "Johnson", LocalDate.of(1975, 4, 25));
//        Author author4 = new Author("Emily", "Davis", LocalDate.of(1985, 7, 18));
//        Author author5 = new Author("William", "Brown", LocalDate.of(1992, 11, 20));
//        Author author6 = new Author("Olivia", "Wilson", LocalDate.of(1988, 2, 15));
//
//        // Сохранение авторов
//        authorRepository.save(author1);
//        authorRepository.save(author2);
//        authorRepository.save(author3);
//        authorRepository.save(author4);
//        authorRepository.save(author5);
//        authorRepository.save(author6);
//
////        // Добавление книг
//        Book book1 = new Book("The Great Book", 2005);
//        Book book2 = new Book("Another Book", 2010);
//        Book book3 = new Book("Learn Java Quickly", 2020);
//        Book book4 = new Book("Spring Boot in Action", 2018);
//        Book book5 = new Book("Advanced Hibernate", 2017);
//        Book book6 = new Book("PostgreSQL Basics", 2021);
//        Book book7 = new Book("Microservices with Spring", 2019);
//        Book book8 = new Book("Data Structures and Algorithms", 2022);
////
//        // Сохранение книг
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);
//        bookRepository.save(book4);
//        bookRepository.save(book5);
//        bookRepository.save(book6);
//        bookRepository.save(book7);
//        bookRepository.save(book8);
//
//        // Связывание авторов и книг
////        book1.getAuthors().add(author1);
////        book2.getAuthors().add(author2);
////        book3.getAuthors().add(author3);
////        book4.getAuthors().add(author4);
////        book5.getAuthors().add(author5);
////        book6.getAuthors().add(author6);
////        book7.getAuthors().add(author1);
////        book8.getAuthors().add(author2);
//
//        // Сохранение изменений в книгах
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);
//        bookRepository.save(book4);
//        bookRepository.save(book5);
//        bookRepository.save(book6);
//        bookRepository.save(book7);
//        bookRepository.save(book8);
////
////        // Добавление читателей
//        Reader reader1 = new Reader("1234567890", "Michael", "Johnson", "Male", LocalDate.of(1995, 3, 25));
//        Reader reader2 = new Reader("0987654321", "Emily", "Davis", "Female", LocalDate.of(1992, 7, 18));
//        Reader reader3 = new Reader("1122334455", "Daniel", "Martin", "Male", LocalDate.of(1985, 1, 10));
//        Reader reader4 = new Reader("2233445566", "Olivia", "Williams", "Female", LocalDate.of(1990, 12, 5));
//        Reader reader5 = new Reader("3344556677", "Sophia", "Taylor", "Female", LocalDate.of(1994, 4, 15));
//        Reader reader6 = new Reader("4455667788", "James", "Anderson", "Male", LocalDate.of(1988, 6, 23));
//
//        // Сохранение читателей
//        readerRepository.save(reader1);
//        readerRepository.save(reader2);
//        readerRepository.save(reader3);
//        readerRepository.save(reader4);
//        readerRepository.save(reader5);
//        readerRepository.save(reader6);
//
//        Transactional transaction1 = new Transactional(book1, LocalDateTime.now(), "BORROW", reader1);
//        Transactional transaction2 = new Transactional(book2, LocalDateTime.now(), "RETURN", reader2);
//        Transactional transaction3 = new Transactional(book3, LocalDateTime.now(), "BORROW", reader3);
//        Transactional transaction4 = new Transactional(book4, LocalDateTime.now(), "BORROW", reader4);
//        Transactional transaction5 = new Transactional(book5, LocalDateTime.now(), "RETURN", reader5);
//        Transactional transaction6 = new Transactional(book6, LocalDateTime.now(), "BORROW", reader6);
//        Transactional transaction7 = new Transactional(book7, LocalDateTime.now(), "RETURN", reader1);
//        Transactional transaction8 = new Transactional(book8, LocalDateTime.now(), "BORROW", reader4);
//
//        // Сохранение транзакций
//        transactionalRepository.save(transaction1);
//        transactionalRepository.save(transaction2);
//        transactionalRepository.save(transaction3);
//        transactionalRepository.save(transaction4);
//        transactionalRepository.save(transaction5);
//        transactionalRepository.save(transaction6);
//        transactionalRepository.save(transaction7);
//        transactionalRepository.save(transaction8);
//    }
}
