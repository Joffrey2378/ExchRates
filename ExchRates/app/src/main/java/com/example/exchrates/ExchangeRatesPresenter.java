package com.example.exchrates;

import com.example.exchrates.currency.OpenExchangeBank;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExchangeRatesPresenter {
    private final OpenExchangeBank openExchangeBank;
    private final ExchangeRatesView view;

    public ExchangeRatesPresenter(OpenExchangeBank openExchangeBank, ExchangeRatesView view) {
        this.openExchangeBank = openExchangeBank;
        this.view = view;
    }

    public void onViewIsPrepared() {
        openExchangeBank.getRatesFor("USD")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showExchangeRate);
    }
}
