package com.example.quanlytaichinh.service.transaction;

import com.example.quanlytaichinh.model.entity.transactions.Transations;
import com.example.quanlytaichinh.repo.transactionRepository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public Transations createTransaction(Transations transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Iterable<Transations> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transations getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    @Override
    public Transations updateTransaction(Long transactionId, Transations transaction) {
        Transations existingTransaction = transactionRepository.findById(transactionId).orElse(null);
        if (existingTransaction != null) {
            existingTransaction.setAmount(transaction.getAmount());
            existingTransaction.setDescription(transaction.getDescription());
            existingTransaction.setTransactionDate(transaction.getTransactionDate());
            existingTransaction.setType(transaction.getType());
            existingTransaction.setStatus(transaction.getStatus());
            existingTransaction.setCategory(transaction.getCategory());
            existingTransaction.setPaymentMethod(transaction.getPaymentMethod());
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }
}
