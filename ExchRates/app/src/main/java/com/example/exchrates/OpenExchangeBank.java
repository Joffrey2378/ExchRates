package com.example.exchrates;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import dto.RatesResponseDTO;
import network.OpenExchangeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenExchangeBank {
    private final OpenExchangeApi api;

    OpenExchangeBank(OpenExchangeApi api) {
        this.api = api;
    }

    void getRatesFor(String currencyCode, final Consumer<Map<String, BigDecimal>> callbackResponse) {

        final Call<RatesResponseDTO> ratesRequest = api.getRates(currencyCode);
        ratesRequest.enqueue(new Callback<RatesResponseDTO>() {
            @Override
            public void onResponse(Call<RatesResponseDTO> call,
                                   Response<RatesResponseDTO> response) {
                callbackResponse.consume(response.body().getRates().getExchangeRates());
            }

            @Override
            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {

            }
        });
//            if (ratesResponse.isSuccessful()) {
//                final RatesResponseDTO responseDTO = ratesResponse.body();
//            } else {
//                throw new RuntimeException();
//            }
    }
}
