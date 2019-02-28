package com.example.exchrates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExchangeRatesAdapter extends RecyclerView.Adapter<ExchangeRatesAdapter.ExchangeRatesViewHolder> {
    private List<CurrencyPresentationModel> rates;

    @NonNull
    @Override
    public ExchangeRatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.holder_exchange_rate_entry, viewGroup, false);
        return new ExchangeRatesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExchangeRatesViewHolder exchangeRatesViewHolder, int i) {
        CurrencyPresentationModel currentModel = rates.get(i);
        exchangeRatesViewHolder.currencyCode.setText(currentModel.getCurrencyCode());
        exchangeRatesViewHolder.rate.setText(currentModel.getRate().toString());
    }

    @Override
    public int getItemCount() {
        return rates.size();
    }

    public class ExchangeRatesViewHolder extends RecyclerView.ViewHolder {
        private TextView currencyCode;
        private TextView rate;
        private ImageView diffirentiationArrys;

        public ExchangeRatesViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyCode = itemView.findViewById(R.id.currency_code);
            rate = itemView.findViewById(R.id.rate);
            diffirentiationArrys = itemView.findViewById(R.id.differentiator_sign);
        }
    }
}
