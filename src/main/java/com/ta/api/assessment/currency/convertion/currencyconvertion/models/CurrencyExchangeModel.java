package com.ta.api.assessment.currency.convertion.currencyconvertion.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "id",
        "convertion_multiple",
        "currency_from",
        "currency_to"
})
public class CurrencyExchangeModel {

    private int id;

    @JsonProperty("convertion_multiple")
    private double convertionMultiple;

    @JsonProperty("currency_from")
    private String currencyFrom;

    @JsonProperty("currency_to")
    private String currencyTo;

}
