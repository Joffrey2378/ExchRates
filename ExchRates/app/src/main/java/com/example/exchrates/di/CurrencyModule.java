package com.example.exchrates.di;

import com.example.exchrates.ExchangeRatesPresenter;
import com.example.exchrates.currency.OpenExchangeBank;
import com.example.exchrates.network.OpenExchangeApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CurrencyModule {

    @Provides
    public Retrofit createRetrofit() {
        return new Retrofit.Builder().baseUrl("https://openexchangerates.org")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public OpenExchangeApi createApi(Retrofit retrofit) {
        return retrofit.create(OpenExchangeApi.class);
    }

    @Provides
    public OpenExchangeBank createBank(OpenExchangeApi api) {
        return new OpenExchangeBank(api);
    }

    @Provides
    public ExchangeRatesPresenter createPresenter(OpenExchangeBank bank) {
        return new ExchangeRatesPresenter(bank);
    }

}
