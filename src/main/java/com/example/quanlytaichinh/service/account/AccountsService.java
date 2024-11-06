package com.example.quanlytaichinh.service.account;



import com.example.quanlytaichinh.model.DTO.AccountsDto;
import com.example.quanlytaichinh.model.entity.accounts.Accounts;
import com.example.quanlytaichinh.model.entity.users.User;
import com.example.quanlytaichinh.repo.IUserRepository;
import com.example.quanlytaichinh.repo.accountRespo.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IAccountRepository accountsRepository;

    @Autowired
    private IUserRepository userRepository;



    @Override
    public Iterable<Accounts> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Accounts getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public Accounts updateAccount(Long accountId, Accounts account) {
        Accounts existingAccount = accountRepository.findById(accountId).orElse(null);
        if (existingAccount != null) {
            existingAccount.setAccountName(account.getAccountName());
            existingAccount.setBalance(account.getBalance());
            existingAccount.setStatus(account.getStatus());
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    @Override
    public Accounts createAccount(AccountsDto accountDto) {
        Accounts account = new Accounts();
        account.setAccountName(accountDto.getAccountName());
        account.setAccountType(accountDto.getAccountType());
        account.setBalance(accountDto.getBalance());
        account.setStatus(accountDto.getStatus());

        // Find user by ID
        User user = userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + accountDto.getUserId()));

        // Set the user on the account
        account.setUser(user);

        // Save the account
        return accountsRepository.save(account);

    }
}

