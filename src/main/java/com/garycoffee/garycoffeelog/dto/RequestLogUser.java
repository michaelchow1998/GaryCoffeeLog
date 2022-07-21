package com.garycoffee.garycoffeelog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garycoffee.garycoffeelog.Enum.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestLogUser {

    private String username;

    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    private String message;
}
