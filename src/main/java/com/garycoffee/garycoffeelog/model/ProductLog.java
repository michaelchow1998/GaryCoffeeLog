package com.garycoffee.garycoffeelog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garycoffee.garycoffeelog.Enum.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("OrderLog")
public class ProductLog {

    @Id
    private String id;

    @JsonProperty("staff_id")
    private Integer staffId;

    @JsonProperty("product_short_name")
    private String productShortName;

    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    private Integer amount;

    @JsonProperty("create_date")
    private Date createDate;

}
