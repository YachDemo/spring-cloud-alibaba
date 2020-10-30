package com.example.user.controller;

import com.example.common.ConstantUtils;
import com.example.common.Result;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 14:57
 **/
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Result create(@RequestBody User user) {
        user.setId(ConstantUtils.ID.nextId());
        boolean save = userService.save(user);
        return save ? Result.success() : Result.error();
    }


    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        log.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return Result.success(user);
    }

    @GetMapping("/getUserByIds")
    public Result<List<User>> getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList = userService.getBaseMapper().selectBatchIds(ids);
        log.info("根据ids获取用户信息，用户列表为：{}", userList);
        return Result.success(userList);
    }


    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        userService.removeById(id);
        return Result.success();
    }
}
