
package com.example.exchrates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("UAH")
    @Expose
    private double uAH;

    @SerializedName("RUB")
    @Expose
    private double rUB;

    @SerializedName("CNY")
    @Expose
    private double cNY;

    @SerializedName("JPY")
    @Expose
    private double jPY;

    @SerializedName("EUR")
    @Expose
    private double eUR;

    @SerializedName("GBP")
    @Expose
    private double gBP;

    @SerializedName("CHF")
    @Expose
    private double cHF;

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
