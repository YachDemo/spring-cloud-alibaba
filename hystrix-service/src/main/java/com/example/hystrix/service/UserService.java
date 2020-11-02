package com.example.hystrix.service;

import com.example.common.Result;
import com.example.hystrix.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-11-02 9:20
 **/
@Service
@Slf4j
public class UserService {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public Result getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    public Result getDefaultUser(@PathVariable Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("defaultUser");
        user.setPassword("123456");
        user.setSalt("");
        user.setCreateTime(0);
        user.setUpdateTime(0);
        return Result.success(user);
    }

    @HystrixCommand(fallbackMethod = "getDefaultUser2", ignoreExceptions = {NullPointerException.class})
    public Result getUserExcption(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{639374141397690718}", Result.class, id);
    }

    public Result getDefaultUser2(@PathVariable Long id, Throwable e) {
        User defaultUser = new User();
        defaultUser.setId(-2L);
        defaultUser.setUsername("defaultUser");
        defaultUser.setPassword("123456");
        defaultUser.setSalt("");
        defaultUser.setCreateTime(0);
        defaultUser.setUpdateTime(0);
        return Result.success(defaultUser);
    }

    @HystrixCommand(fallbackMethod = "getUserDefault",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    public Result getUserCommand(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{639374141397690718}", Result.class, id);
    }
}
