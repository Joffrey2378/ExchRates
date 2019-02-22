package com.example.exchrates;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import dto.RatesResponseDTO;
import network.OpenExchangeApi;
import retrofit2.Call;
import retrofit2.Response;

public class OpenExchangeBank {
    private final OpenExchangeApi api;

    public OpenExchangeBank(OpenExchangeApi api) {
        this.api = api;
    }

    public Map<String, BigDecimal> getRatesFor(String currencyCode) {

        try {
            final Call<RatesResponseDTO> ratesRequest = api.getRates(currencyCode);
            final Response<RatesResponseDTO> ratesResponse = ratesRequest.execute();
            if (ratesResponse.isSuccessful()) {
                final RatesResponseDTO responseDTO = ratesResponse.body();
                return responseDTO.getRates().getExchangeRates();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
