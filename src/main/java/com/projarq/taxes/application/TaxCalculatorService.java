package com.projarq.taxes.application;

import org.springframework.stereotype.Service;

import com.projarq.taxes.domain.Tax;
import com.projarq.taxes.domain.TaxCalculator;
import com.projarq.taxes.domain.TaxRepository;

@Service
public class TaxCalculatorService implements TaxCalculator {
    private final TaxRepository taxRepository;

    public TaxCalculatorService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public double calculateTax(String state, double value) {
        Tax tax = taxRepository.findByState(state);
        if (tax == null) {
            throw new IllegalArgumentException("Imposto não encontrado para o estado: " + state);
        }
        return value * tax.getRate();
    }
} 