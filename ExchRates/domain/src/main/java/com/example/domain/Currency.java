package com.example.domain;

import java.math.BigDecimal;

public interface Currency {

    CharSequence getCurrencyCode();

    BigDecimal getRate(Currency compareWith);
}
