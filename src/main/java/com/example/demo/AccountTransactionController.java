package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountTransactionController {

    @Autowired
    AccountTransactionRepository accountTransRespository;

    @GetMapping("/transaction")
    public List<AccountTransaction> getTransaction() {
        return accountTransRespository.findAll();
    }

    @GetMapping("/transaction/{transactionNo}")
    public Optional<AccountTransaction> getTransactionById(@PathVariable(value = "transactionNo") int transactionNo) {
        return accountTransRespository.findById(transactionNo);
    }

    @PostMapping("/transaction")
    public @Valid AccountTransaction createTransaction(@Valid @RequestBody AccountTransaction accountTransaction)   {
        return accountTransRespository.save(accountTransaction);
    }

    @PutMapping("/transaction/{transactionNo}")
    public @Valid AccountTransaction updateTransaction(@PathVariable(value = "transactionNo") int transactionNo, @Valid @RequestBody AccountTransaction accountTransaction)
            throws AccountTransactionNotFoundException {
        AccountTransaction transaction = accountTransRespository.findById(transactionNo).orElseThrow(() -> new AccountTransactionNotFoundException(transactionNo));
        transaction.setAccountId(accountTransaction.getAccountId());
        transaction.setTransactionNo(accountTransaction.getTransactionNo());
        transaction.setTransactionAmount(accountTransaction.getTransactionAmount());
        transaction.setTransactionDate(accountTransaction.getTransactionDate());
        transaction.setLoanId(accountTransaction.getLoanId());
        transaction.setPayeeId(accountTransaction.getPayeeId());
        transaction.setTransactionType(accountTransaction.getTransactionType());
        AccountTransaction updateTransaction = accountTransRespository.save(transaction);
        return updateTransaction;
    }

    @DeleteMapping("/transaction/{transactionNo}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("transactionNo") int transactionNo)
            throws AccountTransactionNotFoundException {
        AccountTransaction transaction = accountTransRespository.findById(transactionNo).orElseThrow(() -> new AccountTransactionNotFoundException(transactionNo));
        accountTransRespository.deleteById(transactionNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
