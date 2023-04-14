package com.ta.api.assessment.currency.convertion.currencyconvertion.services;

import com.ta.api.assessment.currency.convertion.currencyconvertion.models.CurrencyExchangeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8080")
public interface CurrencyExchangeService {
    @GetMapping("/api/currency-exchange/from/{from}/to/{to}")
    CurrencyExchangeModel getCurrencyExchangeService(@PathVariable String from, @PathVariable String to);

}