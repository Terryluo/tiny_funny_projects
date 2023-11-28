package com.calculator.calculator.service;

public abstract class OperationService {
    private Integer numberA;
    private Integer numberB;

    public Integer getNumberA() {
        return numberA;
    }

    public void setNumberA(Integer numberA) {
        this.numberA = numberA;
    }

    public Integer getNumberB() {
        return numberB;
    }

    public void setNumberB(Integer numberB) {
        this.numberB = numberB;
    }

    public abstract String getResult(Integer numberA, Integer numberB);
}
