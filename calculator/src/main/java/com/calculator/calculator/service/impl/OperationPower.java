package com.calculator.calculator.service.impl;

import com.calculator.calculator.service.OperationService;

public class OperationPower extends OperationService {
    @Override
    public String getResult(Integer numberA, Integer numberB) {
        return power(numberA, numberB);
    }

    private String power(Integer numberA, Integer numberB) {
        if (numberA == 0 && numberB == 0) {
            return "Undefined value";
        } else if (numberA == 0) {
            return "0";
        } else if (numberB == 0) {
            return "1";
        }
        return String.valueOf(calPower(numberA, numberB));
    }

    private Long calPower(Integer numberA, Integer numberB) {
        if (numberB == 1) {
            return (long)numberA;
        }
        long half = calPower(numberA, numberB / 2);
        if (numberB % 2 == 0) {
            return half * half;
        } else {
            return numberA * half * half;
        }
    }
}
