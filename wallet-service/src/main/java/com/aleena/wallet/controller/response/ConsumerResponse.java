package com.aleena.wallet.controller.response;

import com.aleena.wallet.repository.entity.ConsumerType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class ConsumerResponse {
    private String consumerId;
    private String uamId;
    private String name;
    private ConsumerType type;
    private List<String> wallets;
}
