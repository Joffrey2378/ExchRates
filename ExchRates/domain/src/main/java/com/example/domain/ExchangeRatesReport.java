package com.example.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesReport {
    private final Map<String, BigDecimal> yesterdays;
    private final Map<String, BigDecimal> todays;

    public ExchangeRatesReport(Map<String, BigDecimal> yesterdays, Map<String, BigDecimal> today) {
        this.yesterdays = yesterdays;
        this.todays = today;
    }

    public Map<String, BigDecimal> getYesterdays() {
        return yesterdays;
    }

    public Map<String, BigDecimal> getTodays() {
        return todays;
    }

    public List<CurrencyReport> defineDifferenceInEachCurrency() {
        final List<CurrencyReport> differList = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : yesterdays.entrySet()) {
            CurrencyReport currencyReport = new CurrencyReport(entry.getKey(),
                    entry.getValue(), todays.get(entry.getKey()));
            differList.add(currencyReport);
        }
        return differList;
    }
}
