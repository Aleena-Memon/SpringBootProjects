package com.aleena.wallet.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WalletResponse {
        private String walletId;
        private String consumerId;
        private String deviceId;
        private String appId;
        private List<String> paymentMeanIds;
    }

