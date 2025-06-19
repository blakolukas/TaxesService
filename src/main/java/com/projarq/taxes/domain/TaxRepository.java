package com.projarq.taxes.domain;

public interface TaxRepository {
    Tax findByState(String state);
} 