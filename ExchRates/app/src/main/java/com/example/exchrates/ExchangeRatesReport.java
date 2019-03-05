package com.example.exchrates;

import java.math.BigDecimal;
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

    public void defineDifferenceInEachCurrency() {
        for (Map.Entry<String, BigDecimal> entry : yesterdays.entrySet()) {
            final BigDecimal todayRate = todays.get(entry.getKey());
        }
    }
}
