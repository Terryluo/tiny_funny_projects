package com.calculator.calculator.service.impl;

import com.calculator.calculator.service.OperationService;

public class OperationMinus extends OperationService {
    @Override
    public String getResult(Integer numberA, Integer numberB) {
        return String.valueOf(numberA - numberB);
    }
}
