package com.example.exchrates;

import com.example.exchrates.currency.CurrencyReport;
import com.example.exchrates.currency.ExchangeRatesReport;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ExchangeRatesReportTest {
    Map<String, BigDecimal> yesterdays;
    Map<String, BigDecimal> todays;
    ExchangeRatesReport report;
    List<BigDecimal> result;

    @Before
    public void setUp() {
        yesterdays = new HashMap<>();
        todays = new HashMap<>();
        report = new ExchangeRatesReport(yesterdays, todays);
        result = new ArrayList<>();
    }

    private void stubWithDefaultValues() {
        yesterdays.put("UAH", new BigDecimal(10));
        yesterdays.put("RUB", new BigDecimal(20));
        yesterdays.put("CNY", new BigDecimal(30));
        yesterdays.put("JPY", new BigDecimal(40));
        todays.put("UAH", new BigDecimal(5));
        todays.put("RUB", new BigDecimal(10));
        todays.put("CNY", new BigDecimal(20));
        todays.put("JPY", new BigDecimal(30));
    }

    @Test
    public void getYesterdays() {
        stubWithDefaultValues();
        assertEquals(yesterdays, report.getYesterdays());
    }

    @Test
    public void getTodays() {
        stubWithDefaultValues();
        assertEquals(todays, report.getTodays());
    }

    @Test
    public void defineDifferenceInEachCurrencyTesting() {
        report.defineDifferenceInEachCurrency();
    }

    @Test
    public void defineDifferenceInEachCurrency_assertUahReportValues() {
        CurrencyReport exptected = new CurrencyReport("UAH", BigDecimal.ONE, BigDecimal.TEN);
        yesterdays.put("UAH", BigDecimal.ONE);
        todays.put("UAH", BigDecimal.TEN);
        List<CurrencyReport> reports = report.defineDifferenceInEachCurrency();
        CurrencyReport actual = reports.stream()
                .filter(currency -> currency.getCurrencyCode() == "UAH")
                .findFirst()
                .get();
        assertEquals(exptected, actual);
    }
}