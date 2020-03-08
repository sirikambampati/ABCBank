package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BillPayeeController {

    @Autowired
    BillPayeeRepository billPayeeRepository;

    @GetMapping("/billpayee")
    public List<BillPayee> getBillPayee() {
        return billPayeeRepository.findAll();
    }

    @GetMapping("/billpayee/{payeeId}")
    public Optional<BillPayee> getBillPayeeById(@PathVariable(value = "payeeId") String payeeId) {
        return billPayeeRepository.findById(payeeId);
    }

    @PostMapping("/billpayee")
    public @Valid BillPayee createBillPayee(@Valid @RequestBody BillPayee billPayee) {
        return billPayeeRepository.save(billPayee);
    }

    @PutMapping("/billpayee/{payeeId}")
    public @Valid BillPayee updateBillPayee(@PathVariable(value = "payeeId") String payeeId, @Valid @RequestBody BillPayee billPay)
            throws BillPayeeNotFoundException {
        BillPayee billPayee = billPayeeRepository.findById(payeeId).orElseThrow(() -> new BillPayeeNotFoundException(payeeId));
        billPayee.setPayeeId(billPay.getPayeeId());
        billPayee.setUserId(billPay.getUserId());
        billPayee.setPayeeAccountNo(billPay.getPayeeAccountNo());
        billPayee.setPayeePhone(billPay.getPayeePhone());
        billPayee.setPayeeAddress(billPay.getPayeeAddress());
        BillPayee updateBillPayee = billPayeeRepository.save(billPayee);
        return updateBillPayee;
    }

    @DeleteMapping("/billpayee/{id}")
    public ResponseEntity<Void> deleteBillPayee(@PathVariable("payeeId") String payeeId)
            throws BillPayeeNotFoundException {
        BillPayee billPayee = billPayeeRepository.findById(payeeId).orElseThrow(() -> new BillPayeeNotFoundException(payeeId));
        billPayeeRepository.deleteById(payeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
