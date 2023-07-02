package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.TransactionCreateRequest;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public String transact(@RequestBody @Valid TransactionCreateRequest request) throws JsonProcessingException {
        return transactionService.transact(request);
    }
}
