package com.aleena.wallet.repository;

import com.aleena.wallet.repository.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}
