package com.projarq.taxes.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.taxes.domain.Tax;
import com.projarq.taxes.domain.TaxCalculator;
import com.projarq.taxes.domain.TaxRepository;
import com.projarq.taxes.infra.dto.TaxCalculationRequestDTO;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {
    private final TaxCalculator taxCalculator;
    private final TaxRepository taxRepository;

    public TaxController(TaxCalculator taxCalculator, TaxRepository taxRepository) {
        this.taxCalculator = taxCalculator;
        this.taxRepository = taxRepository;
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

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }
} 