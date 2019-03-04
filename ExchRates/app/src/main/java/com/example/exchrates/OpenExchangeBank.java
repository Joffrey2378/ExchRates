package com.example.exchrates;

import java.math.BigDecimal;
import java.util.Map;

import dto.RatesResponseDTO;
import network.OpenExchangeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenExchangeBank {
    private final OpenExchangeApi api;
    private TimeFactory timeFactory = new TimeFactory();

    OpenExchangeBank(OpenExchangeApi api) {
        this.api = api;
    }

    void getRatesFor(final String currencyCode, final Consumer<Map<String, BigDecimal>> consumer) {
        String dateTime = timeFactory.giveYesterdaysDate();
        api.getYesterdaysRates(dateTime, currencyCode).enqueue(new Callback<RatesResponseDTO>() {
            @Override
            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
                Map<String, BigDecimal> rates = response.body().getRates().getExchangeRates();
                consumer.consume(rates);
            }

            @Override
            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
            }
        });
//        api.getRates(currencyCode).enqueue(new Callback<RatesResponseDTO>() {
//            @Override
//            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
//                Map<String, BigDecimal> rates = response.body().getRates().getExchangeRates();
//                consumer.consume(rates);
//            }
//
//            @Override
//            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
//            }
//        });
    }
}
