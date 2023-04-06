package com.ta.api.assessment.currency.convertion.currencyconvertion.controllers;

import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyConvertionModel;
import com.ta.api.assessment.currency.convertion.currencyconvertion.services.CurrencyConvertionService;
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

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionModel getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        return currencyConvertionService.currencyConversionCalculation(from, to, quantity);
    }



}