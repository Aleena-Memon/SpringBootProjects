package com.example.WalletWise.Entity;

import jakarta.persistence.*;

@Entity
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primaryKey;

    private String uamId;
    private String consumerId;
    private String name;

    @Enumerated(EnumType.STRING)
    private ConsumerType type;

    private String externalId;

    // Getters and Setters
    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getUamId() {
        return uamId;
    }

    public void setUamId(String uamId) {
        this.uamId = uamId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConsumerType getType() {
        return type;
    }

    public void setType(ConsumerType type) {
        this.type = type;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}

enum ConsumerType {
    Bussnss, Prvt
}
