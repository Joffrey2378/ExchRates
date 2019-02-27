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
        openExchangeBank.getRatesFor("USD", new Consumer<Map<String, BigDecimal>>() {

            @Override
            public void consume(Map<String, BigDecimal> exchangeRates) {
//                BigDecimal uah = exchangeRates.get("UAH");
                view.showExchangeRate(exchangeRates);
            }
        });
    }
}
