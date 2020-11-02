package com.example.feign.controller;

import com.example.common.Result;
import com.example.feign.domain.User;
import com.example.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-11-02 16:43
 **/
@RestController
@RequestMapping("/user/")
public class UserFeignController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public Result getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }


    @PostMapping("/create")
    public Result create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
