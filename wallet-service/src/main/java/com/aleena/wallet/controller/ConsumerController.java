package com.aleena.wallet.controller;

import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping
    public List<Consumer> getAllConsumers(){
        return consumerService.getAllConsumers();
    }

    @PostMapping
    public ResponseEntity<Consumer> createConsumer(@RequestBody Consumer consumer){
     Consumer saveConsumer = consumerService.createConsumer(consumer);
     return new ResponseEntity<Consumer>(saveConsumer, HttpStatus.CREATED);

    }


}
