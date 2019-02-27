package com.example.exchrates;

import java.math.BigDecimal;
import java.util.Map;

public interface ExchangeRatesView {

    void showExchangeRate(Map<String, BigDecimal> rate);
}
