package com.example.SMSBilling.repository;

import com.example.SMSBilling.entity.PlanSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanSubscriptionRepository extends JpaRepository<PlanSubscription, Long> {

    @Query(value="select plan_id from plansubscription where cust_id = ?1", nativeQuery = true)
    Long getSubscription(Long cust_id);

}
