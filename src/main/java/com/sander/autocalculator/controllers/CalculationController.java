package com.sander.autocalculator.controllers;

import com.sander.autocalculator.common.EngineType;
import com.sander.autocalculator.common.PortName;
import com.sander.autocalculator.models.CalculationData;
import com.sander.autocalculator.models.CalculationResult;
import com.sander.autocalculator.models.User;
import com.sander.autocalculator.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CalculationController {

    private final CalculateService calculateService;

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String addCalculation(@RequestParam String modelName,
                                 @RequestParam int lotPrice,
                                 @RequestParam int yearProduction,
                                 @RequestParam double engineVolume,
                                 @RequestParam EngineType engineType,
                                 @RequestParam PortName portName) {
        CalculationData calculationData = new CalculationData(modelName, lotPrice, yearProduction,
                engineVolume, engineType, portName);
        CalculationResult calculationResult = calculateService.calculateAndSave(calculationData);

        return "redirect:/result/" + calculationResult.getId();
    }

    @ResponseBody
    @GetMapping("/result/{id}")
    public CalculationResult getResult(@PathVariable Long id) {

        return calculateService.getCalculationResult(id);
    }

    @PostMapping("/result")
    public String saveResult() {
        return "result";
    }
}
