package com.sander.autocalculator.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "calculation_result")
public class CalculationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double taxCustomResult;
    private double shipmentResult;
    private double totalPriceResult;
}
