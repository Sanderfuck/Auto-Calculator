package com.sander.autocalculator.common;

public enum PortName {
    NEW_JERSEY(700),
    GEORGIA(750),
    FLORIDA(800),
    TEXAS(900),
    CALIFORNIA(1100);    ;

    private int portPrice;

    PortName(int portPrice) {
        this.portPrice = portPrice;
    }

    public int getPortPrice() {
        return portPrice;
    }
}
