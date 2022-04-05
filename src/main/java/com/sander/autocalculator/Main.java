package com.sander.autocalculator;

import com.sander.autocalculator.common.EngineType;
import com.sander.autocalculator.models.CalculationData;
import com.sander.autocalculator.service.CalculateServiceImpl;

public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        Singleton singleton3 = Singleton.getSingleton();

        System.out.println(singleton1 == singleton3);

//        CalculationData data = new CalculationData("Audi", 1500, 2013, 2.0, EngineType.GASOLINE, "New Jersey" );
//        CalculateServiceImpl calculateService = new CalculateServiceImpl();
//        System.out.println(calculateService.calculateTotalPrice(data));
    }
}
