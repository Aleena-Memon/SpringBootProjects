package com.aleena.wallet.controller;

import com.aleena.wallet.controller.response.WalletResponse;
import com.aleena.wallet.repository.entity.Wallet;
import com.aleena.wallet.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private WalletService walletService;

//    @GetMapping
//    public List<WalletResponse> getAllWallets() {
//        List<Wallet> wallets = walletService.getAllWallets();
//
//        return wallets.stream().map(wallet -> new WalletResponse(
//                wallet.getWalletId(),
//                wallet.getConsumer() != null ? wallet.getConsumer().getConsumerId() : null,
//                wallet.getDeviceId(),
//                wallet.getAppId(),
//                wallet.getPaymentMeans().stream()
//                        .map(paymentMean -> paymentMean.getPaymentMeanId())
//                        .collect(Collectors.toList())
//        )).collect(Collectors.toList());
//    }

}