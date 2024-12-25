package com.aleena.wallet.controller;

import com.aleena.wallet.controller.request.ConsumerRequest;
import com.aleena.wallet.controller.response.ConsumerResponse;
import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping
    public List<ConsumerResponse> getAllConsumers() {
        List<Consumer> consumers = consumerService.getAllConsumers();

        List<ConsumerResponse> consumerResponses = consumers.stream()
                .map(consumer -> new ConsumerResponse(
                        consumer.getConsumerId(),
                        consumer.getUamId(),
                        consumer.getName(),
                        consumer.getType(),
                        consumer.getWallets().stream().map(wallet -> wallet.getWalletId())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        return consumerResponses;
    }

   @PostMapping
    public ResponseEntity<ConsumerResponse> createConsumer(@RequestBody ConsumerRequest consumerRequest){
        Consumer consumer = new Consumer(
                null,
                consumerRequest.getUamId(),
                consumerRequest.getName(),
                consumerRequest.getType(),
                List.of()  // empty list
        );

        Consumer consumerSaved = consumerService.createConsumer(consumer);

        // map this consumer to response
       ConsumerResponse response = new ConsumerResponse(
               consumerSaved.getConsumerId(),
               consumerSaved.getUamId(),
               consumerSaved.getName(),
               consumerSaved.getType(),
               consumerSaved.getWallets() != null ? consumerSaved.getWallets().stream()
                       .map(wallet -> wallet.getWalletId()).collect(Collectors.toList()) : List.of()
       );
       return new ResponseEntity<>(response, HttpStatus.CREATED);
   }
}
