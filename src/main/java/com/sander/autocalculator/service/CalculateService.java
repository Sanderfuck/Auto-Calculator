package com.sander.autocalculator.service;

import com.sander.autocalculator.models.CalculationData;
import com.sander.autocalculator.models.CalculationResult;

public interface CalculateService {

    CalculationResult calculateAndSave(CalculationData calculationData);

    CalculationResult getCalculationResult(Long id);
}
