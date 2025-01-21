package com.example.library.controller;


import com.example.library.model.Transactional;
import com.example.library.services.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionalController {

    @Autowired
    private final TransactionalService transactionalService;

    public TransactionalController(TransactionalService transactionService) {
        this.transactionalService = transactionService;
    }

    @PostMapping("/process")
    public String processTransaction(
            @RequestParam Long readerId,
            @RequestParam Long bookId,
            @RequestParam String operationType) {
        return transactionalService.processTransaction(String.valueOf(readerId), bookId, operationType);
    }

    @GetMapping
    public List<Transactional> getAllTransactions() {
        return transactionalService.getAllTransactions();
    }

    @PostMapping
    public Transactional createTransactional(@RequestBody Transactional transactional) {
        return transactionalService.addTransaction(transactional);
    }

    @DeleteMapping("/{id}")
    public void deleteTransactional(@PathVariable Long id) {
        transactionalService.deleteTransaction(id);
    }
}
