package com.projarq.taxes.domain;

public interface TaxCalculator {
    double calculateTax(String state, double value);
} 