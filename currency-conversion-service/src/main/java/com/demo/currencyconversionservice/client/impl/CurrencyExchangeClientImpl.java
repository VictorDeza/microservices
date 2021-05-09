package com.demo.currencyconversionservice.client.impl;

import com.demo.currencyconversionservice.client.CurrencyExchangeClient;
import com.demo.currencyconversionservice.models.bean.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CurrencyExchangeClientImpl implements CurrencyExchangeClient {

    @Override
    public CurrencyConversion retrieveCurrencyExchange(String from, String to) {
        String URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity(URL, CurrencyConversion.class, uriVariables);
        return responseEntity.getBody();
    }
}