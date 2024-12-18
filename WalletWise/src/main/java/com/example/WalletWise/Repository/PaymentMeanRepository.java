package com.example.WalletWise.Repository;

import com.example.WalletWise.Entity.PaymentMeans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMeanRepository extends JpaRepository<PaymentMeans, String> {
}
