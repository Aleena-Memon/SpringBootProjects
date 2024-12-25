package com.aleena.wallet.repository;

import com.aleena.wallet.repository.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumerRepository extends JpaRepository<Consumer, String>, JpaSpecificationExecutor<Consumer> {
}
