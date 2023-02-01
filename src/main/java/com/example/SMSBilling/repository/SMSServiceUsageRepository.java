package com.example.SMSBilling.repository;

import com.example.SMSBilling.entity.SMSServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SMSServiceUsageRepository extends JpaRepository<SMSServiceUsage, Long> {

    @Transactional
    @Modifying
    @Query(value="update SMSServiceUsage s set s.sms_count = s.sms_count+?3 where s.cust_id = ?1 and s.usage_month = ?2", nativeQuery = true)
    void updateUsageForCustomer(long cust_id, Integer month, int count);

    @Query(value="select * from SMSServiceUsage where cust_id = ?1 and usage_month = ?2", nativeQuery = true)
    SMSServiceUsage getUsageForCustomer(long cust_id, Integer month);
}
