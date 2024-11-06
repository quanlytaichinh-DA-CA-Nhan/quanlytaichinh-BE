package com.example.quanlytaichinh.service.account;


import com.example.quanlytaichinh.model.DTO.AccountsDto;
import com.example.quanlytaichinh.model.entity.accounts.Accounts;

public interface IAccountService {

    Iterable<Accounts> getAllAccounts();
    Accounts getAccountById(Long accountId);
    Accounts updateAccount(Long accountId, Accounts account);
    Accounts createAccount(AccountsDto accountDto);
}
