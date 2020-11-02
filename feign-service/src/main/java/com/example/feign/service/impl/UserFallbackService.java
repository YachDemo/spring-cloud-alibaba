package com.example.feign.service.impl;

import com.example.common.Result;
import com.example.feign.domain.User;
import com.example.feign.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Feign中的服务降级使用起来非常方便，
 * 只需要为Feign客户端定义的接口添加一个服务降级处理的实现类即可，
 * 下面我们为UserService接口添加一个服务降级实现类。
 * <p>
 * 需要注意的是它实现了UserService接口，
 * 并且对接口中的每个实现方法进行了服务降级逻辑的实现。
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-11-02 16:51
 **/
@Component
public class UserFallbackService implements UserService {
    @Override
    public Result create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return Result.success(defaultUser);
    }

    @Override
    public Result<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return Result.success(defaultUser);
    }

    @Override
    public Result<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return Result.success(defaultUser);
    }

    @Override
    public Result update(User user) {
        return Result.error();
    }

    @Override
    public Result delete(Long id) {
        return Result.error();
    }
}
