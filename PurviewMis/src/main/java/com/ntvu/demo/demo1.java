package com.ntvu.demo;

import com.ntvu.server.entity.user;
import com.ntvu.server.mapper.UserMapper;
import com.ntvu.util.mybatisUntil;

import java.util.List;



public class demo1 {

    public static void main(String[] args) {

        UserMapper userMapper = mybatisUntil.getSqlSession().getMapper(UserMapper.class);
        List<user> users = userMapper.getAllUser();
        for (user user1 : users) {
            System.out.println(user1);
        }
    }
}
