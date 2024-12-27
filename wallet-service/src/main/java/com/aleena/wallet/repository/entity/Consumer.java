package com.aleena.wallet.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@ToString
@Getter
@Setter
@Entity
@Table(name="consumer")
public class Consumer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extConsumerId;

    private String uamId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ConsumerType type;

//
//    @ToString.Exclude
//    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL,  orphanRemoval = true)
//    private List<Wallet> wallets = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Consumer that = (Consumer) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

