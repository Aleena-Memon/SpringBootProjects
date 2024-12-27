package com.aleena.wallet.service;

import com.aleena.wallet.repository.WalletRepository;
import com.aleena.wallet.repository.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private WalletRepository walletRepository;

    public List<Wallet> getAllWallets(){
        return walletRepository.findAll();
    }

    public Wallet createWallet(Wallet wallet){
        return walletRepository.save(wallet);
    }

}
