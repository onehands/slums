package com.slums.hands.mapper;

import com.slums.hands.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/19 16:48
 * @version: 1.0
 */
public interface UserMapper {
    List<UserModel> selectAll();
    UserModel selectById(@Param("id")int id);
}
