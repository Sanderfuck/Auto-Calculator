package com.sander.autocalculator.repository;

import com.sander.autocalculator.models.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}
