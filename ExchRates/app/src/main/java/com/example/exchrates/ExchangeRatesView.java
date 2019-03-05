package com.example.exchrates;

import com.example.exchrates.currency.CurrencyReport;

import java.util.List;

public interface ExchangeRatesView {

    void showExchangeRate(List<CurrencyReport> rate);
}
