package com.aleena.wallet.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_source")
public class PaymentSource {
    @Id
    private String paymentSourceId;

    private String iban;

    private String ibanAlias;

    @OneToMany(mappedBy = "paymentSource", cascade = CascadeType.ALL)
    private List<PaymentMeans> paymentMeans;

}
