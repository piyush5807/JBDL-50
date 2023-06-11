package com.example.minor1.controllers;

import com.example.minor1.dtos.InitiateTransactionRequest;
import com.example.minor1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public String initiateTxn(@RequestBody @Valid InitiateTransactionRequest transactionRequest) throws Exception {

        // student id :
        // book id
        // admin id
        // txn type

        return transactionService.initiateTxn(transactionRequest);
    }

    @PostMapping("/transaction/payment")
    public void makePayment(@RequestParam("amount") Integer amount,
                            @RequestParam("studentId") Integer studentId,
                            @RequestParam("transactionId") String txnId) throws Exception {
        transactionService.payFine(amount, studentId, txnId);
    }
}
