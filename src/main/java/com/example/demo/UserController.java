package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getRegistration() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable(value = "userId") String userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/user")
    public @Valid User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{userId}")
    public @Valid User updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody User userDetails)
            throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        user.setUserId(userDetails.getUserId());
        user.setFirstName(userDetails.getFirstName());
        user.setMiddleName(userDetails.getMiddleName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());
        user.setMobileNumber(userDetails.getMobileNumber());
        user.setPassword(userDetails.getPassword());
        User updateUser = userRepository.save(user);
        return updateUser;
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId)
            throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
