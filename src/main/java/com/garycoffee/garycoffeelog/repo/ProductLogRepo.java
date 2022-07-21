package com.garycoffee.garycoffeelog.repo;

import com.garycoffee.garycoffeelog.model.ProductLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductLogRepo extends MongoRepository<ProductLog, String> {

    List<ProductLog> findAllByProductShortName(String shortName);
}
