package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account")
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/account/{accountId}")
    public Optional<Account> getAccountById(@PathVariable(value = "accountId") String accountId) {
        return accountRepository.findById(accountId);
    }

    @PostMapping("/account")
    public @Valid Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/account/{accountId}")
    public @Valid Account updateAccount(@PathVariable(value = "accountId") String accountId, @Valid @RequestBody Account accountDetails)
            throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        account.setAccountId(accountDetails.getAccountId());
        account.setAccountName(accountDetails.getAccountName());
        account.setAccountAddress(accountDetails.getAccountAddress());
        account.setAccountStatus(accountDetails.getAccountStatus());
        account.setAccountType(accountDetails.getAccountType());
        account.setEmailId(accountDetails.getEmailId());
        account.setMobileNumber(accountDetails.getMobileNumber());
        account.setDateOpen(accountDetails.getDateOpen());
        account.setDateClosed(accountDetails.getDateClosed());
        Account updateAccount = accountRepository.save(account);
        return updateAccount;
    }

    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("accountId") String accountId)
            throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        accountRepository.deleteById(accountId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
