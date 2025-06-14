package com.pmt.workshop.repository;

import com.pmt.workshop.entity.EffortDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogHoursRepository extends JpaRepository<EffortDetails,Long> {
}
