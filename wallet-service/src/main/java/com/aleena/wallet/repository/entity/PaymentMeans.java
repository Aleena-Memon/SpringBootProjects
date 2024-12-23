package com.aleena.wallet.repository.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_means")
public class PaymentMeans {
    @Id
    private String paymentMeanId;

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "payment_source_id", referencedColumnName = "paymentSourceId")
    private PaymentSource paymentSource;

}
