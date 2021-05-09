package com.demo.currencyconversionservice.web.resource;

import com.demo.currencyconversionservice.client.CurrencyExchangeClient;
import com.demo.currencyconversionservice.client.CurrencyExchangeProxy;
import com.demo.currencyconversionservice.models.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionResource {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveCurrencyExchange(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculateAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
        return currencyConversion;
    }
}