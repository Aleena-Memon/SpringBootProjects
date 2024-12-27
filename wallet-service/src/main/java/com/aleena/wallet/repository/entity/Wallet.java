package com.aleena.wallet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@ToString
@Getter
@Setter
@Entity
@Table(name="wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extWalletId;
//
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "consumer_id", nullable = false)
//    private Consumer consumer;

    private String deviceId;
    private String appId;

//    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
//    private List<PaymentMeans> paymentMeans;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wallet that = (Wallet) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
