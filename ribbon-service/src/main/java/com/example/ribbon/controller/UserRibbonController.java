package com.example.ribbon.controller;

import com.example.common.Result;
import com.example.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 注入RestTemplate，使用其调用user-service中提供的相关接口，
 * 这里对GET和POST调用进行了演示，其他方法调用均可参考。
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 15:52
 **/
@RestController
@RequestMapping("/user")
public class UserRibbonController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;


    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    @GetMapping("/getByUsername")
    public Result getByUsername(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", Result.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public Result getEntityByUsername(@RequestParam String username) {
        ResponseEntity<Result> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", Result.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/create")
    public Result create(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, Result.class);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, Result.class);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, Result.class, id);
    }
}

