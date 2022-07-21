package com.garycoffee.garycoffeelog.repo;

import com.garycoffee.garycoffeelog.model.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLogRepo extends MongoRepository<UserLog, String> {


}
