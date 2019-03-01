package com.example.exchrates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import network.OpenExchangeApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExchangeRatesActivity extends AppCompatActivity implements ExchangeRatesView {
    private ExchangeRatesPresenter presenter;
    private ExchangeRatesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExchangeRatesAdapter();
        recyclerView.setAdapter(adapter);

        initializePresenter();
        presenter.onViewIsPrepared();
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
        adapter.populate(rate);
    }
}
