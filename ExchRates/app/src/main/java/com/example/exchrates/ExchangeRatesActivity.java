package com.example.exchrates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.domain.CurrencyReport;
import com.example.exchrates.application.ExchangeRatesApplication;

import java.util.List;

import javax.inject.Inject;

public class ExchangeRatesActivity extends AppCompatActivity implements ExchangeRatesView {

    @Inject
    ExchangeRatesPresenter presenter;
    private ExchangeRatesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolveDependencies();
        presenter.setView(this);
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

    private void resolveDependencies() {
        ExchangeRatesApplication application = (ExchangeRatesApplication) getApplication();
        application.getInjector().inject(this);
    }

    @Override
    public void showExchangeRate(List<CurrencyReport> reports) {
        adapter.populate(reports);
    }
}
