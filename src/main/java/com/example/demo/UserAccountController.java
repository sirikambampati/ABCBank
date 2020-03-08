package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/useraccount")
    public List<UserAccount> getUserAccount() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/useraccount/{userId}")
    public Optional<UserAccount> getUserAccountById(@PathVariable(value = "userId") String userId) {
        return userAccountRepository.findById(userId);
    }

    @PostMapping("/useraccount")
    public @Valid UserAccount createUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @PutMapping("/useraccount/{userId}")
    public @Valid UserAccount updateUserAccount(@PathVariable(value = "userId") String userId, @Valid @RequestBody UserAccount userAccount)
            throws UserAccountNotFoundException {
        UserAccount uAccount = userAccountRepository.findById(userId).orElseThrow(() -> new UserAccountNotFoundException(userId));
        uAccount.setAccountId(userAccount.getAccountId());
        uAccount.setUserId(userAccount.getUserId());
        UserAccount updateUserAccount = userAccountRepository.save(uAccount);
        return updateUserAccount;
    }

    @DeleteMapping("/useraccount/{userId}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable("userId") String userId)
            throws UserAccountNotFoundException {
        UserAccount userAccount = userAccountRepository.findById(userId).orElseThrow(() -> new UserAccountNotFoundException(userId));
        userAccountRepository.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
