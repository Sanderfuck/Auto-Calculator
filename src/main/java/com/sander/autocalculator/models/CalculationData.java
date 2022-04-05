package com.sander.autocalculator.models;

import com.sander.autocalculator.common.EngineType;
import com.sander.autocalculator.common.PortName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@Table(name = "calculation_data")
public class CalculationData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "lot_price")
    private int lotPrice;

    @Column(name = "year_production")
    private int yearProduction;

    @Column(name = "engine_volume")
    private double engineVolume;

    @Column(name = "engine_type")
    private EngineType engineType;

    @Column(name = "port_name")
    private PortName portName;

    @ManyToOne
    private User user;

    public CalculationData() {
    }

    public CalculationData(String modelName, int lotPrice, int yearProduction,
                           double engineVolume, EngineType engineType, PortName portName) {
        this.modelName = modelName;
        this.lotPrice = lotPrice;
        this.yearProduction = yearProduction;
        this.engineVolume = engineVolume;
        this.engineType = engineType;
        this.portName = portName;
    }
}
