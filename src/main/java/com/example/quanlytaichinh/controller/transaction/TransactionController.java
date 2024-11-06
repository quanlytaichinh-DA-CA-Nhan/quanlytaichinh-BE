package com.example.quanlytaichinh.controller.transaction;


import com.example.quanlytaichinh.model.entity.transactions.Transations;

import com.example.quanlytaichinh.repo.transactionRepository.ITransactionRepository;
import com.example.quanlytaichinh.service.transaction.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transations> createTransaction(@RequestBody Transations transaction) {
        Transations newTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Transations>> getAllTransactions() {
        Iterable<Transations> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transations> getTransactionById(@PathVariable Long id) {
        Transations transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transations> updateTransaction(@PathVariable Long id, @RequestBody Transations transaction) {
        Transations updatedTransaction = transactionService.updateTransaction(id, transaction);
        if (updatedTransaction != null) {
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
