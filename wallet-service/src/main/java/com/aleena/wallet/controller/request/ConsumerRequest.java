package com.aleena.wallet.controller.request;


import com.aleena.wallet.repository.entity.ConsumerType;
import lombok.Data;

import java.util.List;


@Data
public class ConsumerRequest {
    private String uamId;
    private String name;
    private ConsumerType type;
    private List<String> wallets;
}

