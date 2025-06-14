package com.pmt.workshop.repository;

import com.pmt.workshop.entity.JobRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminWorkRepository extends JpaRepository<JobRate,String> {
}
