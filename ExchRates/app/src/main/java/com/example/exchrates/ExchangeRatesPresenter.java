package com.example.exchrates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesPresenter {
    private final OpenExchangeBank openExchangeBank;
    private final ExchangeRatesView view;
    private List<CurrencyPresentationModel> convertedRates = new ArrayList<>();

    public ExchangeRatesPresenter(OpenExchangeBank openExchangeBank, ExchangeRatesView view) {
        this.openExchangeBank = openExchangeBank;
        this.view = view;
    }

    public void onViewIsPrepared() {
        openExchangeBank.getRatesFor("USD", new Consumer<Map<String, BigDecimal>>() {

            @Override
            public void consume(Map<String, BigDecimal> exchangeRates) {
                for (Map.Entry<String, BigDecimal> entry :
                        exchangeRates.entrySet()) {
                    convertedRates.add(new CurrencyPresentationModel(entry.getKey(), entry.getValue()));
                }
                view.showExchangeRate(convertedRates);
            }
        });
    }
}
