package com.projarq.taxes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxes")
public class Tax {
    @Id
    private String state;
    private double rate;

    public Tax() {} // JPA requires a no-args constructor

    public Tax(String state, double rate) {
        this.state = state;
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public double getRate() {
        return rate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
