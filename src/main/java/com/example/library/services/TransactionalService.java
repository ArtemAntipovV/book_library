package com.example.library.services;


import com.example.library.model.Book;
import com.example.library.model.Reader;
import com.example.library.model.Transactional;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionalService {

    @Autowired
    private TransactionalRepository transactionalRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    public String processTransaction(String readerId, Long bookId, String operationType) {
        Optional<Reader> readerOptional = readerRepository.findById(readerId);
        Optional<Book> bookOptional= bookRepository.findById(bookId);
        if (readerOptional.isEmpty() || bookOptional.isEmpty()) {
            return "Reader or Book not found!";
        }

        Reader reader = readerOptional.get();
        Book book = bookOptional.get();

        // Создание транзакции
        Transactional transaction = new Transactional();
        transaction.setReader(reader);
        transaction.setBook(book);
        transaction.setOperationType(operationType);
        transaction.setDateTime(LocalDateTime.now());

        transactionalRepository.save(transaction);

        return "Transaction processed successfully!";
    }



    public List<Transactional> getAllTransactions() {
        return transactionalRepository.findAll();
    }

    public Transactional addTransaction(Transactional transactional) {
        return transactionalRepository.save(transactional);
    }

    public void deleteTransaction(Long id) {
        transactionalRepository.deleteById(id);
    }

}


