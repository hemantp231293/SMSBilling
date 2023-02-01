package com.example.SMSBilling.repository;

import com.example.SMSBilling.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query(value ="select * from plan where plan_id = ?1", nativeQuery = true)
    Plan getPlan(Long id);
}
