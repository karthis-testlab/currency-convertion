package com.ta.api.assessment.currency.convertion.currencyconvertion.services;

import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyConvertionModel;
import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyExchangeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyConvertionService {
    RestTemplate restTemplate = new RestTemplate();
    public CurrencyConvertionModel currencyConversionCalculation(String from, String to, int quantity) {
        String url = "http://localhost:8080/api/currency-exchange/from/"+from+"/to/"+to;
        ResponseEntity<CurrencyExchangeModel> responseEntity = restTemplate.getForEntity(url, CurrencyExchangeModel.class);
        CurrencyConvertionModel response = CurrencyConvertionModel.builder()
                                           .quantity(quantity)
                                           .totalCalculateAmount(calculateTotalAmount(responseEntity.getBody().getConvertionMultiple(), quantity))
                                           .currencyExchange(responseEntity.getBody()).build();
        return response;
    }

    private double calculateTotalAmount(double currencyConvertion, int quantity) {
        double amount = currencyConvertion * quantity;
        return new BigDecimal(amount).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

}