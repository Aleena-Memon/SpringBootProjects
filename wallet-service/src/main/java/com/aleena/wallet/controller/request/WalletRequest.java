package com.aleena.wallet.controller.request;

import lombok.Data;

@Data
public class WalletRequest {

        private String walletId;
        private String consumerId;
        private String deviceId;
        private String appId;
    }

