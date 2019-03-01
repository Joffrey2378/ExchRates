package com.example.exchrates;

import java.math.BigDecimal;

public class CurrencyPresentationModel {
    private final String currencyCode;
    private final BigDecimal rate;

    public CurrencyPresentationModel(String currencyCode, BigDecimal rate) {
        this.currencyCode = currencyCode;
        this.rate = rate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return currencyCode + " = " + rate + "\n";
    }
}
