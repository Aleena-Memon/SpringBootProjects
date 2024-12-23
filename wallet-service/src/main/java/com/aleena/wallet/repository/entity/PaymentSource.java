package com.aleena.wallet.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PaymentSource {
    @Id
    private String paymentSourceId;

    private String iban;
    private String paymentMeanId;
    private String ibanAlias;

    // Getters and Setters

    public String getPaymentSourceId() {
        return paymentSourceId;
    }

    public void setPaymentSourceId(String paymentSourceId) {
        this.paymentSourceId = paymentSourceId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPaymentMeanId() {
        return paymentMeanId;
    }

    public void setPaymentMeanId(String paymentMeanId) {
        this.paymentMeanId = paymentMeanId;
    }

    public String getIbanAlias() {
        return ibanAlias;
    }

    public void setIbanAlias(String ibanAlias) {
        this.ibanAlias = ibanAlias;
    }
}
