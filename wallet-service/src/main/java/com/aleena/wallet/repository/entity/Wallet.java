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
@Table(name="wallet")
public class Wallet {
    @Id
    private String walletId;

    @ManyToOne
    @JoinColumn(name = "consumer_id", referencedColumnName = "consumerId")
    private Consumer consumer;

    private String deviceId;
    private String appId;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<PaymentMeans> paymentMeans;


}
