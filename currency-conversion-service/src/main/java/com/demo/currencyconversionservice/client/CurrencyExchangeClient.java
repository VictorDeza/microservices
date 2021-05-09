package com.demo.currencyconversionservice.client;

import com.demo.currencyconversionservice.models.bean.CurrencyConversion;

public interface CurrencyExchangeClient {
    CurrencyConversion retrieveCurrencyExchange(String from, String to);
}
