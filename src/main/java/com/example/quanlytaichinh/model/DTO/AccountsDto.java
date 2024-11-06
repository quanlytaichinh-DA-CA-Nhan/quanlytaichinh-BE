package com.example.quanlytaichinh.model.DTO;

import com.example.quanlytaichinh.model.entity.users.AccountStatus;
import com.example.quanlytaichinh.model.entity.users.AccountType;

public class AccountsDto {
    private String accountName;
    private AccountType accountType;
    private Double balance;
    private AccountStatus status;
    private Long userId; // Store the user ID instead of the entire User object

    // Getters and Setters
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
