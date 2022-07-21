package com.garycoffee.garycoffeelog.controller;

import com.garycoffee.garycoffeelog.dto.RequestLogProduct;
import com.garycoffee.garycoffeelog.model.ProductLog;
import com.garycoffee.garycoffeelog.service.ProductLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/product-log")
@AllArgsConstructor
@Slf4j
public class ProductLogController {

    @Resource
    private ProductLogService productLogService;

    @PostMapping
    public ResponseEntity<String> logProductDetail(@RequestBody RequestLogProduct req){
        log.info("Get request for create UserLog");
        String message = productLogService.logProductDetail(req);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/product-log").toUriString());
        return ResponseEntity.created(uri).body(message);
    }

    @GetMapping
    public ResponseEntity<List<ProductLog>> fetchAllProductLogs(){
        List<ProductLog> productLogList = productLogService.fetchAllProductLog();
        return ResponseEntity.ok().body(productLogList);
    }

    @GetMapping("/{shortName}")
    public ResponseEntity<List<ProductLog>> findAllByProductShortName(@PathVariable String shortName){
        List<ProductLog> productLogList = productLogService.findAllByProductShortName(shortName);
        return ResponseEntity.ok().body(productLogList);
    }

}
