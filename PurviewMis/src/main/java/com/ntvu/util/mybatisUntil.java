package com.ntvu.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
public class mybatisUntil {



    private static SqlSessionFactory sqlSessionFactory;
    static { try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) { e.printStackTrace(); } }


    //            工厂模式获取sqlSession对象，用以执行sql语句
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }



}

