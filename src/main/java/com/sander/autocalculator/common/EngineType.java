package com.sander.autocalculator.common;

public enum EngineType {
    GASOLINE(50),
    DIESEL(75);

    private int engineTypeCoef;

    EngineType(int engineTypeCoef) {
        this.engineTypeCoef = engineTypeCoef;
    }

    public int getEngineTypeCoef() {
        return engineTypeCoef;
    }
}
