package com.ntvu.server.entity;

public class user {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String realname;
    private String email;
    private String telephone;
    private boolean sex;
    private int age;

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return password;
    }

    public void setPasword(String pasword) {
        this.password = pasword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public user(String username, String password, String salt, String realname, String email, String telephone, boolean sex, int age) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realname = realname;
        this.email = email;
        this.telephone = telephone;
        this.sex = sex;
        this.age = age;
    }

    public user(String username, String password, String salt, String realname, String email, String telephone) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realname = realname;
        this.email = email;
        this.telephone = telephone;
    }

    public user(String username, String password, String salt, String realname, String email, String telephone, int age) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realname = realname;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }

    public user(String username, String password, String salt, String realname, String email, String telephone, boolean sex) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realname = realname;
        this.email = email;
        this.telephone = telephone;
        this.sex = sex;
    }
}
