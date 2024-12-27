package com.aleena.wallet.service;

import com.aleena.wallet.controller.request.ConsumerCreateRequest;
import com.aleena.wallet.controller.request.WalletCreateRequest;
import com.aleena.wallet.controller.response.ConsumerCreateResponse;
import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.repository.ConsumerRepository;
import com.aleena.wallet.repository.entity.Wallet;
import com.aleena.wallet.repository.specification.ConsumerSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {


    private final ConsumerRepository consumerRepository;

//     Fetch all consumers and return as a list of ConsumerCreateResponse.
    public List<ConsumerCreateResponse> getAllConsumers() {
        List<Consumer> consumers = consumerRepository.findAll();
        return consumers.stream().map(this::convert)
                .collect(Collectors.toList());
    }

  //  Create a new consumer and return the response object.
    public ConsumerCreateResponse createConsumer(ConsumerCreateRequest request) {
        log.info("creating consumer: {}",request );
        final Consumer consumer = convert(request);
        final Consumer savedConsumer= consumerRepository.save(consumer);
        log.info("created consumer: {}",savedConsumer );
        return convert(savedConsumer);
    }

    //Convert a ConsumerCreateRequest to a Consumer entity.
    private Consumer convert(ConsumerCreateRequest request) {
        Consumer consumer = new Consumer();
        consumer.setExtConsumerId(request.getExtConsumerId());
        consumer.setUamId(request.getUamId());
        consumer.setName(request.getName());
        consumer.setType(request.getType());
//       consumer.setWallets(request.getWallets().stream().map(this::convert).collect(Collectors.toList()) );

        return consumer;
    }

    //Convert a WalletCreateRequest to a Wallet entity.
    private Wallet convert(WalletCreateRequest request) {
        Wallet wallet = new Wallet();
        wallet.setExtWalletId(request.getExtWalletId());
        wallet.setAppId(request.getAppId());
        wallet.setDeviceId(request.getDeviceId());
        return wallet;
    }

 //Convert a Consumer entity to a ConsumerCreateResponse.
    private ConsumerCreateResponse convert(Consumer consumer){
        ConsumerCreateResponse createResponse = new ConsumerCreateResponse();
        createResponse.setConsumerId(consumer.getId());
        createResponse.setUamId(consumer.getUamId());
        createResponse.setName(consumer.getName());
        createResponse.setType(consumer.getType());
        //createResponse.setWallets(consumer.get);
        return createResponse;
    }



//    public Consumer updateConsumer(Consumer consumer) {
//        if (consumer.getConsumerId() == null || !consumerRepository.existsById(consumer.getConsumerId())) {
//            throw new IllegalArgumentException("Consumer not found for update");
//        }
//        return consumerRepository.save(consumer);
//    }
//
//    public void deleteConsumer(String consumerId) {
//        if (!consumerRepository.existsById(consumerId)) {
//            throw new IllegalArgumentException("Consumer not found for deletion");
//        }
//        consumerRepository.deleteById(consumerId);
//    }
//
//    public List<Consumer> getConsumerByWalletId(String walletId){
//        return consumerRepository.findAll(ConsumerSpecification.findByWalletId(walletId));
//    }
//
//    public List<Consumer> getConsumerByPaymentMeanId(String paymentMeanId){
//        return consumerRepository.findAll(ConsumerSpecification.findByPaymentMeanId(paymentMeanId));
//    }
}
