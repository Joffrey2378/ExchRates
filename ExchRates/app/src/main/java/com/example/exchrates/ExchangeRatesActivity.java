package com.example.exchrates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.domain.CurrencyReport;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.List;

public class ExchangeRatesActivity extends AppCompatActivity implements ExchangeRatesView {
    private ExchangeRatesPresenter presenter;
    private ExchangeRatesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JodaTimeAndroid.init(this);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(new MarginDivider(16));
        recyclerView.addItemDecoration(decoration);
        adapter = new ExchangeRatesAdapter();
        recyclerView.setAdapter(adapter);
        presenter.onViewIsPrepared();
    }

    @Override
    public void showExchangeRate(List<CurrencyReport> reports) {
        adapter.populate(reports);
    }
}
