package com.projarq.taxes.infra.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.taxes.domain.TaxCalculator;
import com.projarq.taxes.infra.dto.TaxCalculationRequestDTO;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {
    private final TaxCalculator taxCalculator;

    public TaxController(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "Bem vindo ao serviço de impostos da Projarq!";
    }

    @PostMapping("/calculate")
    @CrossOrigin(origins = "*")
    public Double calculateTax(@RequestBody TaxCalculationRequestDTO request) {
        try {
            double result = taxCalculator.calculateTax(request.getState(), request.getValue());
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
} 