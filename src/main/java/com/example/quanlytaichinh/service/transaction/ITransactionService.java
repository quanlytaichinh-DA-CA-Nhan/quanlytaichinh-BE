package com.example.quanlytaichinh.service.transaction;

import com.example.quanlytaichinh.model.entity.transactions.Transations;

public interface ITransactionService {
    Transations createTransaction(Transations transaction);
    Iterable<Transations> getAllTransactions();
    Transations getTransactionById(Long transactionId);
    Transations updateTransaction(Long transactionId, Transations transaction);
}
