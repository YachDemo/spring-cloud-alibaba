package com.example.hystrix.controller;

import com.example.common.Result;
import com.example.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 16:27
 **/
@RestController
public class UserHystrixController {
    @Autowired
    UserService userService;


    @GetMapping("/testFallback/{id}")
    public Result testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/testCommand/{id}")
    public Result testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }

    @GetMapping("/testException/{id}")
    public Result testException(@PathVariable Long id) {
        return userService.getUserExcption(id);
    }

}
