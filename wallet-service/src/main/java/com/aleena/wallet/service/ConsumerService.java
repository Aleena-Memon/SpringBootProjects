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


    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();
    }

    public ConsumerCreateResponse createConsumer(ConsumerCreateRequest request) {
        log.info("creating consumer: {}",request );
        final Consumer consumer = convert(request);
        final Consumer savedConsumer= consumerRepository.save(consumer);
        log.info("created consumer: {}",savedConsumer );
        return convert(savedConsumer);
    }

    private Consumer convert(ConsumerCreateRequest request) {
        Consumer consumer = new Consumer();
        consumer.setExtConsumerId(request.getExtConsumerId());
        consumer.setUamId(request.getUamId());
        consumer.setName(request.getName());
        consumer.setType(request.getType());
//        consumer.setWallets(request.getWallets().stream().map(this::convert).collect(Collectors.toList()) );

        return consumer;
    }

    private ConsumerCreateResponse convert(Consumer consumer){
        ConsumerCreateResponse createResponse = new ConsumerCreateResponse();
        createResponse.setConsumerId(consumer.getId());
        return createResponse;
    }

    private Wallet convert(WalletCreateRequest request) {
        Wallet wallet = new Wallet();
        wallet.setExtWalletId(request.getExtWalletId());
        wallet.setAppId(request.getAppId());
        wallet.setDeviceId(request.getDeviceId());
        return wallet;
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
