package com.example.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class CurrencyReport {

    private String currencyCode;
    private BigDecimal yesterdaysRate;
    private BigDecimal todaysRate;

    public CurrencyReport(String currencyCode, BigDecimal yesterdaysRate, BigDecimal todaysRate) {
        this.currencyCode = currencyCode;
        this.yesterdaysRate = yesterdaysRate;
        this.todaysRate = todaysRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getYesterdaysRate() {
        return yesterdaysRate;
    }

    public BigDecimal getTodaysRate() {
        return todaysRate;
    }

    public BigDecimal getDifference() {
        return todaysRate.subtract(yesterdaysRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyReport that = (CurrencyReport) o;
        return Objects.equals(currencyCode, that.currencyCode) &&
                Objects.equals(yesterdaysRate, that.yesterdaysRate) &&
                Objects.equals(todaysRate, that.todaysRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, yesterdaysRate, todaysRate);
    }
}
