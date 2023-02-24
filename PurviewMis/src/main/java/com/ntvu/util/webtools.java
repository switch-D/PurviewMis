package com.ntvu.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class webtools {
    /**
     *  b？true:false;
     */

    public static  String parseBoolean(boolean b,String trueValue, String falseValue){
        return b? trueValue:falseValue;
    }

    /**
     *  null判断并去除左右两侧空格
     */
    public static String parseNullOrEmpty(Object obj, String defaultValue){
        if (defaultValue==null || defaultValue.equals("")){
            defaultValue="-";
        }
        if (obj == null||obj.toString().equals("")){
           return defaultValue;
        }else{
            return obj.toString().trim();
        }
    }
    /**
     *  null返回”“
     */
    public static String parseNullOrEmpty(Object obj){

        if (obj == null||obj.toString().equals("")){
            return "";
        }else{
            return obj.toString().trim();
        }
    }


    public static String md5(String oldContent) {
        if(oldContent == null || oldContent.equals(""))
        {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
            md.update(oldContent.getBytes());// 计算md5函数
            String hashedPwd = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
            return hashedPwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
