package com.example.exchrates.application;

import android.app.Application;

import com.example.exchrates.di.ApplicationComponent;
import com.example.exchrates.di.CurrencyModule;
import com.example.exchrates.di.DaggerApplicationComponent;

import net.danlew.android.joda.JodaTimeAndroid;

public class ExchangeRatesApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        initializeDagger();
    }

    private void initializeDagger() {
        component = DaggerApplicationComponent.builder()
                .currencyModule(new CurrencyModule())
                .build();
    }

    public ApplicationComponent getInjector() {
        return component;
    }

}
