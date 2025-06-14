package com.pmt.workshop.repository;

import com.pmt.workshop.entity.JobRate;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRateRepository extends JpaRepository<JobRate,String> {
}
