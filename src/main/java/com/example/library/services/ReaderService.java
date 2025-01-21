package com.example.library.services;


import com.example.library.model.Reader;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private TransactionalRepository transactionalRepository;

    public Reader findMostActiveReader() {
        List<Object[]> result = transactionalRepository.findMostActiveReader();
        if (result.isEmpty()) {
            return null;
        }

        Object[] mostActiveReaderData = result.get(0);
        // Теперь это строка, а не Long
        String phoneNumber = (String) mostActiveReaderData[0];
        return readerRepository.findById(phoneNumber).orElse(null);
    }

    public List<Reader> findReadersWithUnreturnedBooks() {
        List<Object[]> result = transactionalRepository.findReadersWithUnreturnedBooks();
        List<Reader> readers = new ArrayList<>();
        for (Object[] row : result) {
            String phoneNumber = (String) row[0];  // Строка, а не Long
            Reader reader = readerRepository.findById(phoneNumber).orElse(null);
            if (reader != null) {
                readers.add(reader);
            }
        }
        return readers;
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderByPhoneNumber(String phoneNumber) {
        return readerRepository.findById(phoneNumber).orElse(null);
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(String phoneNumber) {
        readerRepository.deleteById(phoneNumber);
    }
}
