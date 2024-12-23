package com.aleena.wallet.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


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

    @OneToMany(mappedBy = "consumer")
    private List<Wallet> wallets;

}

