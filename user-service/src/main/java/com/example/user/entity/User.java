package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 14:56
 **/
@Data
@TableName(value = "`user`")
public class User {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "`password`")
    private String password;

    @TableField(value = "salt")
    private String salt;

    @TableField(value = "create_time")
    private Integer createTime;

    @TableField(value = "update_time")
    private Integer updateTime;
}