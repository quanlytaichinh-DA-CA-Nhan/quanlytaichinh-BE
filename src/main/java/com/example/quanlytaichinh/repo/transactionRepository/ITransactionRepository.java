package com.example.quanlytaichinh.repo.transactionRepository;

import com.example.quanlytaichinh.model.entity.transactions.TransactionType;
import com.example.quanlytaichinh.model.entity.transactions.Transations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transations,Long> {
}
