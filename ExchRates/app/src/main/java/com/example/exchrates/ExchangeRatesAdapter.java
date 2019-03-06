package com.example.exchrates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domain.CurrencyReport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesAdapter extends RecyclerView.Adapter<ExchangeRatesAdapter.ExchangeRatesViewHolder> {
    private List<CurrencyReport> rates = new ArrayList<>();

    @NonNull
    @Override
    public ExchangeRatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.holder_exchange_rate_entry, viewGroup, false);
        return new ExchangeRatesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExchangeRatesViewHolder holder, int i) {
        CurrencyReport currentModel = rates.get(i);
        holder.currencyCode.setText(currentModel.getCurrencyCode());
        holder.rate.setText(currentModel.getTodaysRate().setScale(3, RoundingMode.HALF_DOWN).toString());
        BigDecimal difference = currentModel.getDifference();
        holder.difference.setText(difference.setScale(3, RoundingMode.HALF_DOWN).toString());
        if (difference.doubleValue() > 0.0d) {
            holder.difSign.setImageResource(R.drawable.ic_arrow_up);
        } else if (difference.doubleValue() < 0.0d) {
            holder.difSign.setImageResource(R.drawable.ic_arrow_down);
        } else {
            holder.difSign.setImageResource(R.drawable.ic_default_equal_sign);
        }
    }

    public void populate(final List<CurrencyReport> models) {
        this.rates.clear();
        this.rates.addAll(models);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return rates.size();
    }

    public class ExchangeRatesViewHolder extends RecyclerView.ViewHolder {
        private TextView currencyCode;
        private TextView rate;
        private TextView difference;
        private ImageView difSign;

        public ExchangeRatesViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyCode = itemView.findViewById(R.id.currency_code);
            rate = itemView.findViewById(R.id.rate);
            difference = itemView.findViewById(R.id.difference_tv);
            difSign = itemView.findViewById(R.id.differentiator_sign);
        }
    }
}
