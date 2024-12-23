package com.aleena.wallet.repository;

import com.aleena.wallet.repository.entity.PaymentSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSourceRepository extends JpaRepository<PaymentSource, String> {
}
