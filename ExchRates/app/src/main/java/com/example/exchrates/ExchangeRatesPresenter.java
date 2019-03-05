package com.example.exchrates;

import com.example.exchrates.currency.OpenExchangeBank;

public class ExchangeRatesPresenter {
    private final OpenExchangeBank openExchangeBank;
    private final ExchangeRatesView view;

    public ExchangeRatesPresenter(OpenExchangeBank openExchangeBank, ExchangeRatesView view) {
        this.openExchangeBank = openExchangeBank;
        this.view = view;
    }

    public void onViewIsPrepared() {
        openExchangeBank.getRatesFor("USD", view::showExchangeRate);
    }
}
