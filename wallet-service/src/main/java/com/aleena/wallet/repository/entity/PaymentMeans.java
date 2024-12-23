package com.aleena.wallet.repository.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentMeans {
    @Id
    private String paymentMeanId;

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "payment_source_id", referencedColumnName = "paymentSourceId")
    private PaymentSource paymentSource;

    // Getters and Setters

    public String getPaymentMeanId() {
        return paymentMeanId;
    }

    public void setPaymentMeanId(String paymentMeanId) {
        this.paymentMeanId = paymentMeanId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public PaymentSource getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(PaymentSource paymentSource) {
        this.paymentSource = paymentSource;
    }
}
