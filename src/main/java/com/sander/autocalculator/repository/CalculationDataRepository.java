package com.sander.autocalculator.repository;

import com.sander.autocalculator.models.CalculationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationDataRepository extends JpaRepository<CalculationData, Long> {
}
