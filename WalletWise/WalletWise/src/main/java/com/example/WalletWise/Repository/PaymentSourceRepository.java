package com.example.WalletWise.Repository;

import com.example.WalletWise.Entity.PaymentSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSourceRepository extends JpaRepository<PaymentSource, String> {
}
