package com.example.exchrates;

import com.example.domain.CurrencyReport;
import com.example.exchrates.currency.OpenExchangeBank;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExchangeRatesPresenter {

    private final OpenExchangeBank openExchangeBank;
    private ExchangeRatesView view;

    public ExchangeRatesPresenter(OpenExchangeBank openExchangeBank) {
        this.openExchangeBank = openExchangeBank;
    }

    public void onViewIsPrepared() {
        openExchangeBank.getRatesFor("USD")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showRates);
    }

    private void showRates(List<CurrencyReport> rate) {
        if (view != null) {
            view.showExchangeRate(rate);
        }
    }

    public void setView(ExchangeRatesView view) {
        this.view = view;
    }

    public void releaseView() {
        this.view = null;
    }
}
