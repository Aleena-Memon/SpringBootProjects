package com.aleena.wallet.service;

import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.repository.ConsumerRepository;
import com.aleena.wallet.repository.specification.ConsumerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    public List<Consumer> getAllConsumers(){
        return consumerRepository.findAll();
    }

    public Consumer createConsumer(Consumer consumer){
        return consumerRepository.save(consumer);
    }

    public Consumer updateConsumer(Consumer consumer) {
        if (consumer.getConsumerId() == null || !consumerRepository.existsById(consumer.getConsumerId())) {
            throw new IllegalArgumentException("Consumer not found for update");
        }
        return consumerRepository.save(consumer);
    }

    public void deleteConsumer(String consumerId) {
        if (!consumerRepository.existsById(consumerId)) {
            throw new IllegalArgumentException("Consumer not found for deletion");
        }
        consumerRepository.deleteById(consumerId);
    }

    public List<Consumer> getConsumerByWalletId(String walletId){
        return consumerRepository.findAll(ConsumerSpecification.findByWalletId(walletId));
    }

    public List<Consumer> getConsumerByPaymentMeanId(String paymentMeanId){
        return consumerRepository.findAll(ConsumerSpecification.findByPaymentMeanId(paymentMeanId));
    }
}
