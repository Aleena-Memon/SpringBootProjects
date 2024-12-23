package com.aleena.wallet.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_source")
public class PaymentSource {
    @Id
    private String paymentSourceId;

    private String iban;
    private String paymentMeanId;
    private String ibanAlias;

}
