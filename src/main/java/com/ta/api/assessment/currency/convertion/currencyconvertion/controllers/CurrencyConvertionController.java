package com.ta.api.assessment.currency.convertion.currencyconvertion.controllers;

import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyConvertionModel;
import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyExchangeModel;
import com.ta.api.assessment.currency.convertion.currencyconvertion.services.CurrencyConvertionService;
import com.ta.api.assessment.currency.convertion.currencyconvertion.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyConvertionController {

    @Autowired
    CurrencyConvertionService currencyConvertionService;

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionModel getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        return currencyConvertionService.currencyConversionCalculation(from, to, quantity);
    }

    @GetMapping("/v1/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionModel getCurrencyConversionUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        CurrencyExchangeModel currencyExchangeModel = currencyExchangeService.getCurrencyExchangeService(from, to);
        CurrencyExchangeModel exchange = CurrencyExchangeModel.builder().id(currencyExchangeModel.getId())
                                         .convertionMultiple(currencyExchangeModel.getConvertionMultiple())
                                         .currencyFrom(currencyExchangeModel.getCurrencyFrom()).currencyTo(currencyExchangeModel.getCurrencyTo()).build();
        CurrencyConvertionModel response = CurrencyConvertionModel.builder().currencyExchange(exchange).totalCalculateAmount(currencyExchangeModel.getConvertionMultiple()*quantity).build();
        return response;
    }

}