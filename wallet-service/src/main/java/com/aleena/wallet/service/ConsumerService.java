package com.aleena.wallet.service;

import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.repository.ConsumerRepository;
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

}
