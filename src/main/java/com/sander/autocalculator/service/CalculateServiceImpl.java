package com.sander.autocalculator.service;


import com.sander.autocalculator.models.CalculationData;
import com.sander.autocalculator.models.CalculationResult;
import com.sander.autocalculator.repository.CalculationDataRepository;
import com.sander.autocalculator.repository.CalculationResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private final CalculationDataRepository calculationDataRepository;

    private final CalculationResultRepository calculationResultRepository;

    @Value("${custom-coef}")
    private double customСoef;

    @Value("${tax-coef}")
    private double taxСoef;

    @Value("${broker-and-expedition-price}")
    private double brokerAndExpeditionPrice;

    @Value("${certification-price}")
    private double certificationPrice;

    @Value("${tow-transfer-price}")
    private double towTransferPrice;

    @Value("${ship-add-tax}")
    private double shipAddTax;

    @Override
    public CalculationResult calculateAndSave(CalculationData calculationData) {
        calculationDataRepository.save(calculationData);
        return saveResults(calculationData);
    }

    @Override
    public CalculationResult getCalculationResult(Long id) {
        CalculationResult foundResult = calculationResultRepository.getById(id);
        CalculationResult result = new CalculationResult();
        result.setId(foundResult.getId());
        result.setTotalPriceResult(foundResult.getTotalPriceResult());
        result.setTaxCustomResult(foundResult.getTaxCustomResult());
        result.setShipmentResult(foundResult.getShipmentResult());

        return result;
    }

    private double calculateTotalPrice(CalculationData calculationData) {
        return calculateTaxCustoms(calculationData)
                + calculateInvoice(calculationData.getLotPrice())
                + brokerAndExpeditionPrice
                + certificationPrice
                + towTransferPrice
                + calculationData.getPortName().getPortPrice();
    }

    private static double calculateInvoice(double lotPrice) {
        double auctionCommission;
        if (lotPrice <= 1500) {
            auctionCommission = 400.0;
        } else if (lotPrice > 1500 && lotPrice < 3000) {
            auctionCommission = 500.0;
        } else {
            auctionCommission = 600.0;
        }
        return lotPrice + auctionCommission;
    }

    private double calculateTaxCustoms(CalculationData calculationData) {
        double taxPriceInvoice = calculationData.getLotPrice() + shipAddTax + calculateInvoice(calculationData.getLotPrice());
        double impostCustoms = taxPriceInvoice * customСoef;
        int ageCar = LocalDate.now().getYear() - calculationData.getYearProduction();
        double excise = calculationData.getEngineType().getEngineTypeCoef() * calculationData.getEngineVolume() * ageCar;
        double tax = (taxPriceInvoice + excise + impostCustoms) * taxСoef;
        return impostCustoms + excise + tax;
    }

    private CalculationResult saveResults(CalculationData calculationData) {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setShipmentResult(brokerAndExpeditionPrice + towTransferPrice
                + calculationData.getPortName().getPortPrice());
        calculationResult.setTaxCustomResult(calculateTaxCustoms(calculationData));
        calculationResult.setTotalPriceResult(calculateTotalPrice(calculationData));
        return calculationResultRepository.save(calculationResult);
    }
}
