package com.pmt.workshop.repository;

import com.pmt.workshop.entity.PaymentDue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;


public interface PaymentDueRepository extends JpaRepository<PaymentDue,Long> {
    @Modifying
    @Transactional
    @Query(value = "Update PaymentDue p  set p.amount= p.amount + :value where p.employeeDetails.employeeId= :employeeId and p.month=:month and p.year= :year")
    int updatePaycheckAmount(@Param("employeeId") Long employeeId, @Param("month") String month, @Param("year") String year,@Param("value") Double value);

}
//Update PaymentDue p set p.amount= p.amount + :value where p.employeeId= :employeeId and p.month=:month and p.year= year