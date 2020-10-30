package com.example.user.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.mapper.UserMapper;
import com.example.user.entity.User;
import com.example.user.service.UserService;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 14:56
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
