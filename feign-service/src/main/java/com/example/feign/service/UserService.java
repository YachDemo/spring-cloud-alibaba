package com.example.feign.service;

import com.example.common.Result;
import com.example.feign.domain.User;
import com.example.feign.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 我们通过@FeignClient注解实现了一个Feign客户端，
 * 其中的value为user-service表示这是对user-service服务的接口调用客户端。
 * 我们可以回想下user-service中的UserController，
 * 只需将其改为接口，保留原来的SpringMvc注释即可。
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-11-02 16:38
 **/
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping("/user/create")
    Result create(@RequestBody User user);

    @GetMapping("/user/{id}")
    Result<User> getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    Result<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    Result update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    Result delete(@PathVariable Long id);

}
