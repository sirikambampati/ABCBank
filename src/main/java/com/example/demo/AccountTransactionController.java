package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class AccountTransactionController {

    @Autowired

    AccountTransactionRepository accountTransRespository;

    @GetMapping("/transaction")
    public List<AccountTransaction> getAllTransactions() {
        return accountTransRespository.findAll();
    }

    @GetMapping("/transaction/{accountId}")
    public List getAllTransactionsForAccount(@PathVariable(value = "accountId") String accountId) {
        return accountTransRespository.getTransactionsForAccount(accountId);
    }

    @GetMapping("/transaction/{accountId}/{transactionNo}")
    public Optional<AccountTransaction> getTransactionById(@PathVariable(value = "transactionNo") int transactionNo, @PathVariable(value = "accountId") String accountId) {
        return accountTransRespository.findById(new CustomerIdentity(transactionNo, accountId));
    }

    @PostMapping("/transaction")
    public @Valid AccountTransaction createTransaction(@Valid @RequestBody AccountTransaction accountTransaction) {
        String accountId = accountTransaction.getAccountId();
        float transAmount = accountTransaction.getTransactionAmount();
        //Checking if it is a new account and setting transaction no =1 and setting accountBalance to transAMount
        boolean newAccount = checkIfNewAccount(accountId);
        if (newAccount) {
            accountTransaction.setTransactionNo(1);
            accountTransaction.setAccountBalance(transAmount);
        } else {
            float newBalance;
            float prevBalance;
            int oldTransNo = 0;
            String transType = accountTransaction.getTransactionType();
            List balanceANDTransaction = (accountTransRespository.findPreviousBalance(accountId));
            Object obj[] = (Object[]) balanceANDTransaction.get(0);
            oldTransNo = (int) obj[0];
            prevBalance = (float) obj[1];
            if (transType.equalsIgnoreCase("Deposit"))
                newBalance = prevBalance + transAmount;
            else
                newBalance = prevBalance - transAmount;
            accountTransaction.setAccountBalance(newBalance);
            accountTransaction.setTransactionNo(oldTransNo + 1);
        }
        return accountTransRespository.save(accountTransaction);
    }

    @PutMapping("/transaction/{transactionNo}")
    public void updateTransaction(@PathVariable(value = "transactionNo") int transactionNo, @Valid @RequestBody AccountTransaction accountTransaction)
            throws AccountTransactionNotFoundException {
    }

    @DeleteMapping("/transaction/{accountId}/{transactionNo}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable(value = "transactionNo") int transactionNo, @PathVariable(value = "accountId") String accountId)
            throws AccountTransactionNotFoundException {
        AccountTransaction transaction = accountTransRespository.findById(new CustomerIdentity(transactionNo, accountId)).orElseThrow(() -> new AccountTransactionNotFoundException(transactionNo));
        accountTransRespository.deleteById(new CustomerIdentity(transactionNo, accountId));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    private boolean checkIfNewAccount(String accountId) {
        boolean newAcc = false;
        String newAccount = accountTransRespository.checkIfNewAccount(accountId);
        if (newAccount == null || newAccount.equalsIgnoreCase("True"))
            newAcc = true;
        return newAcc;
    }
}
