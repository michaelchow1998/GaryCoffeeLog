package com.garycoffee.garycoffeelog.controller;

import com.garycoffee.garycoffeelog.dto.RequestLogUser;
import com.garycoffee.garycoffeelog.model.UserLog;
import com.garycoffee.garycoffeelog.service.UserLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/user-log")
@AllArgsConstructor
@Slf4j
public class UserLogController {

    @Resource
    private UserLogService userLogService;

    @PostMapping
    public ResponseEntity<String> logUser(@RequestBody RequestLogUser req){
        log.info("Get request for create UserLog");
        String message = userLogService.logUserBalanceChange(req);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user-log").toUriString());
        return ResponseEntity.created(uri).body(message);
    }

    @GetMapping
    public ResponseEntity<List<UserLog>> fetchAllUserLog(){
        List<UserLog> logs = userLogService.fetchAllUserLog();
        return ResponseEntity.ok().body(logs);
    }
}
