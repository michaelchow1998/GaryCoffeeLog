package com.garycoffee.garycoffeelog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garycoffee.garycoffeelog.Enum.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("UserLog")
public class UserLog {

    @Id
    private String id;

    private String username;

    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    private String message;

    @JsonProperty("modified_date")
    private Date modifiedDate;

}
