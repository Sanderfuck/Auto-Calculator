package com.sander.autocalculator;

import com.sander.autocalculator.common.PortName;
import com.sander.autocalculator.models.CalculationData;
import com.sander.autocalculator.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sander.autocalculator.common.EngineType.GASOLINE;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    CalculateService calculateService;

    static CalculationData calculationData;

    @BeforeAll
    static void init() {
        calculationData = new CalculationData("Audi", 1500, 2013, 2.0, GASOLINE, PortName.NEW_JERSEY);
    }

    @Test
    void totalPriceTest() {
        calculateService.calculateAndSave(calculationData);
        Assertions.assertEquals(6488.0, calculateService.calculateAndSave(calculationData).getTotalPriceResult());
    }

    @Test
    void totalPriceTestByNull() {
        calculationData.setLotPrice(0);
        calculationData.setPortName(PortName.CALIFORNIA);
        calculateService.calculateAndSave(calculationData);
        Assertions.assertEquals(4428.0, calculateService.calculateAndSave(calculationData).getTotalPriceResult());
    }
}
