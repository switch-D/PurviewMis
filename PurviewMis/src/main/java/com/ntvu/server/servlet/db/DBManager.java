package com.ntvu.server.servlet.db;

import com.ntvu.server.entity.user;
import com.ntvu.server.mapper.UserMapper;
import com.ntvu.server.pager.pagerHelper;
import com.ntvu.util.mybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet re = null;
    String sql = null;

    public void into() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/purviewmis_db", "root", "592394314");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if ((re != null) && !re.isClosed()) {
                re.close();
            }
            if ((statement != null) && !statement.isClosed()) {
                statement.close();
            }
            if ((connection != null) && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 注册新用户
     */
    public boolean register(user user) {
        try {
            into();
            //noinspection SqlResolve
            sql = "insert into users(username,password, salt, realname, email, telephone, sex, age)" +
                    " value ('%s','%s','%s','%s','%s','%s',%b,%d)";
            sql = String.format(sql,
                    user.getUsername(),
                    user.getPasword(),
                    user.getSalt(),
                    user.getRealname(),
                    user.getEmail(),
                    user.getTelephone(),
                    user.isSex(),
                    user.getAge());
            int effectedRows = statement.executeUpdate(sql);
            System.out.println(2);
            return effectedRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;

    }

    public user login(String username, String password) {
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user user = mapper.getUserT(username, password);
        sqlSession.close();
        return user;
    }

    public void getList(pagerHelper<user> pager) {
        try {
            into();
            sql = "select * from users  ";
            ResultSet rs = statement.executeQuery(sql);
            //使用结果
            List<user> lst = new ArrayList<>();
            while (rs.next()) {
                user users = new user();
                users.setUsername(rs.getString("username"));
                users.setRealname(rs.getString("realname"));
                users.setEmail(rs.getString("email"));
                users.setTelephone(rs.getString("telephone"));
                users.setSex(rs.getBoolean("sex"));
                users.setAge(rs.getInt("age"));
                lst.add(users);
            }
            pager.setData(lst);
            //关闭
            close();
            //
            int count = getRecordCount();
            pager.setRecordCount(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRecordCount() {
        int count = 0;
        try {
            into();
            sql = "select count(*) from users  ";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
                count = rs.getInt(1);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
