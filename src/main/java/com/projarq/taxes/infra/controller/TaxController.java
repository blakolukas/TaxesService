package com.projarq.taxes.infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.taxes.domain.TaxCalculator;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {
    private final TaxCalculator taxCalculator;

    public TaxController(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateTax(
            @RequestParam String state,
            @RequestParam double value) {
        try {
            double result = taxCalculator.calculateTax(state, value);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 