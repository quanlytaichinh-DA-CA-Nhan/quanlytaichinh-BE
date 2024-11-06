package com.example.quanlytaichinh.repo.accountRespo;

import com.example.quanlytaichinh.model.entity.accounts.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Accounts,Long> {
}
