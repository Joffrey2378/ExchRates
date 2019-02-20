package com.example.exchrates;

import com.example.domain.Currency;

import java.util.Locale;

public interface CurrencyFactory {

    Currency getCurrencyFor(Locale locale);
}
