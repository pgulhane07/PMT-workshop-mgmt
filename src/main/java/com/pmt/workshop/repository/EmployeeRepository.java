package com.pmt.workshop.repository;

import com.pmt.workshop.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Long> {
}
