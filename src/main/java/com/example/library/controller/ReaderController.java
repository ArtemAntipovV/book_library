package com.example.library.controller;

import com.example.library.model.Reader;
import com.example.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }


    @GetMapping("/most-active")
    public Reader getMostActiveReader() {
        return readerService.findMostActiveReader();
    }

    @GetMapping("/unreturned-books")
    public List<Reader> getReadersWithUnreturnedBooks() {
        return readerService.findReadersWithUnreturnedBooks();
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/{phoneNumber}")
    public Reader getReader(@PathVariable String phoneNumber) {
        return readerService.getReaderByPhoneNumber(phoneNumber);
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerService.addReader(reader);
    }

    @DeleteMapping("/{phoneNumber}")
    public void deleteReader(@PathVariable String phoneNumber) {
        readerService.deleteReader(phoneNumber);
    }
}
