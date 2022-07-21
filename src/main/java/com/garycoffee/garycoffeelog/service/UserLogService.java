package com.garycoffee.garycoffeelog.service;

import com.garycoffee.garycoffeelog.dto.RequestLogProduct;
import com.garycoffee.garycoffeelog.dto.RequestLogUser;
import com.garycoffee.garycoffeelog.model.ProductLog;
import com.garycoffee.garycoffeelog.model.UserLog;
import com.garycoffee.garycoffeelog.repo.UserLogRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class UserLogService {

    @Resource
    private UserLogRepo userLogRepo;

    public String logUserBalanceChange(RequestLogUser req){
        UserLog userLog = new UserLog();
        userLog.setUsername(req.getUsername());
        userLog.setTransactionType(req.getTransactionType());
        userLog.setMessage(req.getMessage());

        Date now = new Date();
        userLog.setModifiedDate(now);
        userLogRepo.insert(userLog);

        return "User "+ req.getUsername() +": account balance change logged in Db";
    }

    public List<UserLog> fetchAllUserLog(){
        return userLogRepo.findAll();
    }

}
