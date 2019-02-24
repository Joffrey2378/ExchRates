package com.example.exchrates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.math.BigDecimal;

import retrofit2.Retrofit;

public class ExchangeRatesActivity extends AppCompatActivity implements ExchangeRatesView {
    private TextView currency;
    private ExchangeRatesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializePresenter();

        currency = findViewById(R.id.currency_tv);
        currency.setText("USD - 28.83 UAH");


    }

    private void initializePresenter() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl()
    }

    public void getCurrency() {
    }

    @Override
    public void showExchangeRate(BigDecimal rate) {
        currency.setText(rate.toString());
        throw new UnsupportedOperationException("#showExchangeRate()");
    }
}
