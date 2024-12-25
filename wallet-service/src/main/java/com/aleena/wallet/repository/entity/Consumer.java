package com.aleena.wallet.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="consumer")
public class Consumer {

    @Id
    private String consumerId;

    private String uamId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ConsumerType type;

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    private List<Wallet> wallets;

//    @PrePersist
//    public void generateConsumerId() {
//        if (consumerId == null) {
//            consumerId = UUID.randomUUID().toString(); // Generates a unique UUID
//        }
//
//    }
}

