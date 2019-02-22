package com.example.exchrates;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRatesPresenter {
    private final OpenExchangeBank openExchangeBank;
    private final ExchangeRatesView view;

    public ExchangeRatesPresenter(OpenExchangeBank openExchangeBank, ExchangeRatesView view) {
        this.openExchangeBank = openExchangeBank;
        this.view = view;
    }

    public void onViewIsPrepared() {
        final Map<String, BigDecimal> usd = openExchangeBank.getRatesFor("USD");
        final BigDecimal uahRate = usd.get("UAH");
        view.showExchangeRate(uahRate);
    }
}
