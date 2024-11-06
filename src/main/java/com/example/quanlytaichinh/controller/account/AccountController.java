package com.example.quanlytaichinh.controller.account;


import com.example.quanlytaichinh.model.DTO.AccountsDto;
import com.example.quanlytaichinh.model.entity.accounts.Accounts;
import com.example.quanlytaichinh.repo.IUserRepository;
import com.example.quanlytaichinh.repo.accountRespo.IAccountRepository;
import com.example.quanlytaichinh.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService ;

    @Autowired
    private IAccountRepository accountsRepository;

    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public ResponseEntity<Iterable<Accounts>> getAllAccounts() {
        Iterable<Accounts> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/createAccounts")
    public ResponseEntity<Accounts> createAccount(@RequestBody AccountsDto accountDto) {
        Accounts newAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id) {
        Accounts account = accountService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accounts> updateAccount(@PathVariable Long id, @RequestBody Accounts account) {
        Accounts updatedAccount = accountService.updateAccount(id, account);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
