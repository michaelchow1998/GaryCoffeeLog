package com.garycoffee.garycoffeelog.service;

import com.garycoffee.garycoffeelog.dto.RequestLogProduct;
import com.garycoffee.garycoffeelog.model.ProductLog;
import com.garycoffee.garycoffeelog.repo.ProductLogRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ProductLogService {

    @Resource
    private ProductLogRepo productLogRepo;

    public String logProductDetail(RequestLogProduct req){
        ProductLog productLog = new ProductLog();
        productLog.setStaffId(req.getStaffId());
        productLog.setProductShortName(req.getProductShortName());
        productLog.setTransactionType(req.getTransactionType());
        productLog.setAmount(req.getAmount());
        Date now = new Date();
        productLog.setCreateDate(now);
        productLogRepo.insert(productLog);

        return "This product "+ req.getTransactionType() +" change logged in Db";
    }

    public List<ProductLog> fetchAllProductLog(){
        return productLogRepo.findAll();
    }

    public List<ProductLog> findAllByProductShortName(String shortName){
        return productLogRepo.findAllByProductShortName(shortName);
    }
}
