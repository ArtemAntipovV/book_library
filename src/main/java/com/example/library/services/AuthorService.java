package com.example.library.services;


import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    private final TransactionalRepository transactionalRepository;


    public AuthorService(TransactionalRepository transactionalRepository, AuthorRepository authorRepository) {
        this.transactionalRepository = transactionalRepository;
        this.authorRepository = authorRepository;
    }

    public List<Author> findMostPopularAuthorBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        List<Object[]> borrowedBooks = transactionalRepository.findMostPopularAuthorBetweenDates(startDate, endDate);

        // Если нет данных по транзакциям, возвращаем пустой список
        if (borrowedBooks.isEmpty()) {
            return Collections.emptyList();
        }

        // Получаем книгу, которая была взята больше всего
        Book mostPopularBook = (Book) borrowedBooks.get(0)[0];

        // Получаем авторов книги, которая была самой популярной
        Set<Author> authorsOfMostPopularBook = mostPopularBook.getAuthors();

        return new ArrayList<>(authorsOfMostPopularBook);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
