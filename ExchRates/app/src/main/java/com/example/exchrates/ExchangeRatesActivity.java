package com.example.exchrates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import network.OpenExchangeApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExchangeRatesActivity extends AppCompatActivity implements ExchangeRatesView {
    private TextView currency;
    private ExchangeRatesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currency = findViewById(R.id.currency_tv);

        initializePresenter();
        presenter.onViewIsPrepared();
        final ExchangeRatesAdapter adapter = new ExchangeRatesAdapter();

    }

    private void initializePresenter() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://openexchangerates.org")
                .addConverterFactory(GsonConverterFactory.create()).build();
        OpenExchangeApi api = retrofit.create(OpenExchangeApi.class);

        OpenExchangeBank bank = new OpenExchangeBank(api);
        presenter = new ExchangeRatesPresenter(bank, this);
    }

    @Override
    public void showExchangeRate(List<CurrencyPresentationModel> rate) {

    }
}
