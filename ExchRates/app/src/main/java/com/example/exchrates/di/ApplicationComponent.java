package com.example.exchrates.di;

import com.example.exchrates.ExchangeRatesActivity;

import dagger.Component;

@Component(modules = CurrencyModule.class)
public interface ApplicationComponent {

    void inject(ExchangeRatesActivity activity);

}
