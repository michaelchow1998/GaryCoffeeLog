package com.garycoffee.garycoffeelog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garycoffee.garycoffeelog.Enum.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestLogProduct {

    @JsonProperty("staff_id")
    private Integer staffId;

    @JsonProperty("product_short_name")
    private String productShortName;

    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    private Integer amount;
}
