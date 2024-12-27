package com.aleena.wallet.controller;

import com.aleena.wallet.controller.request.ConsumerCreateRequest;
import com.aleena.wallet.controller.response.ConsumerCreateResponse;
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

//    @GetMapping
//    public List<ConsumerCreateResponse> getAllConsumers() {
//        List<Consumer> consumers = consumerService.getAllConsumers();
//
//        List<ConsumerCreateResponse> consumerResponses = consumers.stream()
//                .map(consumer -> new ConsumerCreateResponse(
////                        consumer.getConsumerId(),
//                        consumer.getUamId(),
//                        consumer.getName(),
//                        consumer.getType(),
//                        consumer.getWallets().stream().map(wallet -> wallet.getWalletId())
//                                .collect(Collectors.toList())
//                ))
//                .collect(Collectors.toList());
//
//        return consumerResponses;
//    }

   @PostMapping
    public ResponseEntity<ConsumerCreateResponse> createConsumer(@RequestBody ConsumerCreateRequest consumerRequest){

       return new ResponseEntity<>(consumerService.createConsumer(consumerRequest), HttpStatus.CREATED);
   }

//    @PutMapping("/{id}")
//    public ResponseEntity<ConsumerResponse> updateConsumer(@PathVariable String id, @RequestBody ConsumerCreateRequest consumerRequest) {
//        Consumer consumer = new Consumer(
//                id,
//                consumerRequest.getUamId(),
//                consumerRequest.getName(),
//                consumerRequest.getType(),
//                List.of()
//        );
//
//        Consumer updatedConsumer = consumerService.updateConsumer(consumer);
//
//        ConsumerResponse response = new ConsumerResponse(
//                updatedConsumer.getConsumerId(),
//                updatedConsumer.getUamId(),
//                updatedConsumer.getName(),
//                updatedConsumer.getType(),
//                updatedConsumer.getWallets() != null ? updatedConsumer.getWallets().stream()
//                        .map(wallet -> wallet.getWalletId()).collect(Collectors.toList()) : List.of()
//        );
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteConsumer(@PathVariable String id) {
//        consumerService.deleteConsumer(id);
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/by-wallet/{walletId}")
//    public List<ConsumerResponse> getConsumersByWalletId(@PathVariable String walletId) {
//        List<Consumer> consumers = consumerService.getConsumerByWalletId(walletId);
//
//        return consumers.stream()
//                .map(consumer -> new ConsumerResponse(
//                        consumer.getConsumerId(),
//                        consumer.getUamId(),
//                        consumer.getName(),
//                        consumer.getType(),
//                        consumer.getWallets().stream().map(wallet -> wallet.getWalletId())
//                                .collect(Collectors.toList())
//                ))
//                .collect(Collectors.toList());
//    }
//    @GetMapping("/by-payment/{paymentId}")
//    public List<ConsumerResponse> getConsumersByPaymentMeanId(@PathVariable String paymentId) {
//
//        List<Consumer> consumers = consumerService.getConsumerByPaymentMeanId(paymentId);
//
//        return consumers.stream()
//                .map(consumer -> new ConsumerResponse(
//                        consumer.getConsumerId(),
//                        consumer.getUamId(),
//                        consumer.getName(),
//                        consumer.getType(),
//                        consumer.getWallets().stream().map(wallet -> wallet.getWalletId())
//                                .collect(Collectors.toList())
//                ))
//                .collect(Collectors.toList());
//    }
}
