package com.example.exchrates;

import retrofit2.Retrofit;

public interface OpenExchangeRatesCurrency {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://openexchangerates.org/api/")
            .build();

    OpenExchangeRatesCurrency api = retrofit.create(OpenExchangeRatesCurrency.class);
}
