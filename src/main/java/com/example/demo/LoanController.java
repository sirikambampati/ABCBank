package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/loan")
    public List<Loan> getLoan() {
        return loanRepository.findAll();
    }

    @GetMapping("/loan/{loanId}")
    public Optional<Loan> getLoanById(@PathVariable(value = "loanId") String loanId) {
        return loanRepository.findById(loanId);
    }

    @PostMapping("/loan")
    public @Valid Loan createLoan(@Valid @RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    @PutMapping("/loan/{loanId}")
    public @Valid Loan updateLoan(@PathVariable(value = "loanId") String loanId, @Valid @RequestBody Loan loanDetails)
            throws LoanNotFoundException {

        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new LoanNotFoundException(loanId));

        loan.setLoanId(loanDetails.getLoanId());
        loan.setAccountId(loanDetails.getAccountId());
        loan.setUserId(loanDetails.getUserId());
        loan.setLoanAmount(loanDetails.getLoanAmount());
        loan.setLoanOpenDate(loanDetails.getLoanOpenDate());
        loan.setLoanStatus(loanDetails.getLoanStatus());
        loan.setLoanTerm(loanDetails.getLoanTerm());
        loan.setLoanType(loanDetails.getLoanType());

        Loan updateLoan = loanRepository.save(loan);
        return updateLoan;
    }

    @DeleteMapping("/loan/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("loanId") String loanId)
            throws LoanNotFoundException {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new LoanNotFoundException(loanId));
        loanRepository.deleteById(loanId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
