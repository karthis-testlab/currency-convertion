package com.ta.api.assessment.currency.convertion.currencyconvertion.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "quantity",
        "totalCalculateAmount",
        "currencyExchange"
})
public class CurrencyConvertionModel {

    private int quantity;

    private double totalCalculateAmount;

    private CurrencyExchangeModel currencyExchange;

}