package com.example.exchrates.dto;

import android.support.v4.util.ArrayMap;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Map;

public class Rates {

    @SerializedName("UAH")
    private double uAH;
    @SerializedName("RUB")
    private double rUB;
    @SerializedName("CNY")
    private double cNY;
    @SerializedName("JPY")
    private double jPY;
    @SerializedName("EUR")
    private double eUR;
    @SerializedName("GBP")
    private double gBP;
    @SerializedName("CHF")
    private double cHF;

    public Map<String, BigDecimal> getExchangeRates() {
        final Map<String, BigDecimal> result = new ArrayMap<>();
        result.put("UAH", new BigDecimal(String.valueOf(uAH)));
        result.put("RUB", new BigDecimal(String.valueOf(rUB)));
        result.put("CNY", new BigDecimal(String.valueOf(cNY)));
        result.put("JPY", new BigDecimal(String.valueOf(jPY)));
        result.put("EUR", new BigDecimal(String.valueOf(eUR)));
        result.put("GBP", new BigDecimal(String.valueOf(gBP)));
        result.put("CHF", new BigDecimal(String.valueOf(cHF)));
        return result;
    }

    public double getCHF() {
        return cHF;
    }

    public void setCHF(double cHF) {
        this.cHF = cHF;
    }

    public double getCNY() {
        return cNY;
    }

    public void setCNY(double cNY) {
        this.cNY = cNY;
    }

    public double getEUR() {
        return eUR;
    }

    public void setEUR(double eUR) {
        this.eUR = eUR;
    }

    public double getGBP() {
        return gBP;
    }

    public void setGBP(double gBP) {
        this.gBP = gBP;
    }

    public double getJPY() {
        return jPY;
    }

    public void setJPY(double jPY) {
        this.jPY = jPY;
    }

    public double getRUB() {
        return rUB;
    }

    public void setRUB(double rUB) {
        this.rUB = rUB;
    }

    public double getUAH() {
        return uAH;
    }

    public void setUAH(double uAH) {
        this.uAH = uAH;
    }

}
