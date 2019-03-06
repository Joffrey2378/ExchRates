package com.example.exchrates.currency;

import com.example.domain.CurrencyReport;
import com.example.domain.ExchangeRatesReport;
import com.example.exchrates.Consumer;
import com.example.exchrates.TimeFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import dto.RatesResponseDTO;
import network.OpenExchangeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenExchangeBank {
    private final OpenExchangeApi api;
    private TimeFactory timeFactory = new TimeFactory();

    public OpenExchangeBank(OpenExchangeApi api) {
        this.api = api;
    }

    public void getRatesFor(final String currencyCode, final Consumer<List<CurrencyReport>> consumer) {
        String dateTime = timeFactory.giveYesterdaysDate();
        api.getYesterdaysRates(dateTime, currencyCode).enqueue(new Callback<RatesResponseDTO>() {
            @Override
            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
                Map<String, BigDecimal> yesterdays = response.body().getRates().getExchangeRates();
                api.getRates(currencyCode).enqueue(new Callback<RatesResponseDTO>() {
                    @Override
                    public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
                        Map<String, BigDecimal> todays = response.body().getRates().getExchangeRates();
                        ExchangeRatesReport exchangeRatesReport = new ExchangeRatesReport(yesterdays, todays);
                        List<CurrencyReport> currencyReports = exchangeRatesReport.defineDifferenceInEachCurrency();
                        consumer.consume(currencyReports);
                    }

                    @Override
                    public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
                    }
                });
            }

            @Override
            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
            }
        });

    }
}
