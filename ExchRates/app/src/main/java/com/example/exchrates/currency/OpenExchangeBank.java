package com.example.exchrates.currency;

import com.example.domain.CurrencyReport;
import com.example.domain.ExchangeRatesReport;
import com.example.exchrates.TimeFactory;

import java.util.List;

import dto.RatesResponseDTO;
import io.reactivex.Single;
import network.OpenExchangeApi;

public class OpenExchangeBank {
    private final OpenExchangeApi api;
    private TimeFactory timeFactory = new TimeFactory();

    public OpenExchangeBank(OpenExchangeApi api) {
        this.api = api;
    }

    public Single<List<CurrencyReport>> getRatesFor(final String currencyCode) {
        String dateTime = timeFactory.giveYesterdaysDate();
        return api.getYesterdaysRates(dateTime, currencyCode)
                .zipWith(api.getRates(currencyCode), this::createExchangeRatesReport)
                .map(ExchangeRatesReport::defineDifferenceInEachCurrency);
//        api.getYesterdaysRates(dateTime, currencyCode).enqueue(new Callback<RatesResponseDTO>() {
//            @Override
//            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
//                Map<String, BigDecimal> yesterdays = response.body().getRates().getExchangeRates();
//                api.getRates(currencyCode).enqueue(new Callback<RatesResponseDTO>() {
//                    @Override
//                    public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
//                        Map<String, BigDecimal> todays = response.body().getRates().getExchangeRates();
//                        ExchangeRatesReport exchangeRatesReport = new ExchangeRatesReport(yesterdays, todays);
//                        List<CurrencyReport> currencyReports = exchangeRatesReport.defineDifferenceInEachCurrency();
//                        consumer.consume(currencyReports);
//                    }
//
//                    @Override
//                    public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
//            }
//        });

    }

    private ExchangeRatesReport createExchangeRatesReport(RatesResponseDTO yesterdays,
                                                          RatesResponseDTO todays) {
        return new ExchangeRatesReport(yesterdays.getRates().getExchangeRates(),
                todays.getRates().getExchangeRates());
    }
}
