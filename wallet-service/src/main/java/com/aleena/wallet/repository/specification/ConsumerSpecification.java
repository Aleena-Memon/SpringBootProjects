package com.aleena.wallet.repository.specification;

import com.aleena.wallet.repository.entity.Consumer;
import com.aleena.wallet.repository.entity.PaymentMeans;
import com.aleena.wallet.repository.entity.Wallet;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class ConsumerSpecification {

    public static Specification<Consumer> findByWalletId(String walletId){
        return(root, query,criteriaBuilder ) -> {
            Join<Consumer, Wallet> walletJoin = root.join("walletId");
            return criteriaBuilder.equal(walletJoin.get("walletId"), walletId);
        };
    }

    public static Specification<Consumer> findByPaymentMeanId(String paymentMeanId){
        return (root, query, criteriaBuilder) -> {
            Join<Consumer, Wallet> walletJoin = root.join("walletId");
            Join<Wallet, PaymentMeans> paymentMeanJoin = walletJoin.join("paymentMeanId");
            return criteriaBuilder.equal(paymentMeanJoin.get("paymentMeanId"),paymentMeanId);
        };
    }

}
