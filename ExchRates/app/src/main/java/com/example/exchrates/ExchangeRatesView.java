package com.example.exchrates;

import com.example.domain.CurrencyReport;

import java.util.List;

public interface ExchangeRatesView {

    void showExchangeRate(List<CurrencyReport> rate);
}
