package com.projarq.taxes.domain;

public class Tax {
    private String state;
    private double rate;

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
