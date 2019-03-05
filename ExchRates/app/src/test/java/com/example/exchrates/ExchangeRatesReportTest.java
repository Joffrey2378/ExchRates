package com.example.exchrates;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRatesReportTest {
    Map<String, BigDecimal> first;
    Map<String, BigDecimal> second;
    ExchangeRatesReport report;

    @Before
    public void setUp() {
        first = new HashMap<>();
        first.put("zero", new BigDecimal("0"));
        first.put("one", new BigDecimal("2"));
        first.put("two", new BigDecimal("3"));
        first.put("three", new BigDecimal("40"));
        second = new HashMap<>();
        second.put("zero", new BigDecimal("10"));
        second.put("one", new BigDecimal("20"));
        second.put("two", new BigDecimal("30"));
        second.put("three", new BigDecimal("40"));
        report = new ExchangeRatesReport(first, second);
    }

    @Test
    public void getYesterdays() {
//        for (Map.Entry<String, BigDecimal> entry : first.entrySet()) {
//            System.out.println(first.get(entry.getKey()));
//        }
        report.getYesterdays();
    }

    @Test
    public void getTodays() {
//        for (Map.Entry<String, BigDecimal> entry : second.entrySet()) {
//            System.out.println(second.get(entry.getKey()));
//        }
        report.getTodays();
    }

    @Test
    public void defineDifferenceInEachCurrency() {
        for (Map.Entry<String, BigDecimal> entry : second.entrySet()) {
            final BigDecimal third = second.get(entry.getKey());
            System.out.println(third);
        }
    }
}