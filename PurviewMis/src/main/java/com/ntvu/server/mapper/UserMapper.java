package com.ntvu.server.mapper;

import com.ntvu.server.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //    查询所有  select  * from users ;
    List<user> getAllUser();

    //      登录验证   根据用户名和 密码查询用户信息
    @Select("select  *  from users where username=#{username} and password=#{password}")
    user getUserT(@Param("username") String username, @Param("password") String password);

    //    根据用户名查询用户信息
    @Select("select  *  from users where username=#{username}")
    user getUser(String username);

    //添加用户
    @Insert("insert into users value (null,#{username},#{password},#{salt},#{reaname},#{email},#{telephone},#{sex},#{age})")
    void addUser(user user);
}
