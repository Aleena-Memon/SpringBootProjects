package com.aleena.wallet.controller.request;

import lombok.Data;

@Data
public class WalletCreateRequest {

        private String extWalletId;
        private String deviceId;
        private String appId;
    }

