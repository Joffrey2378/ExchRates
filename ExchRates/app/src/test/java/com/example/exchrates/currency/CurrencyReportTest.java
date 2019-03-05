package com.example.exchrates.currency;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CurrencyReportTest {

    @Test
    public void getDifference_verifyThatDifferenceIsEqualTo3_ifYesterdaysRateIs10andTodaysIs13() {
        CurrencyReport report = new CurrencyReport("sdf", new BigDecimal("10"),
                new BigDecimal("13"));
        BigDecimal difference = report.getDifference();
        assertEquals(new BigDecimal("3"), difference);
    }

}