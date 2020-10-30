package com.example.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 14:56
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}