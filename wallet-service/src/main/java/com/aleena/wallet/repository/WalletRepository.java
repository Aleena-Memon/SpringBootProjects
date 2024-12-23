package com.aleena.wallet.repository;

import com.aleena.wallet.repository.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,String> {
}
