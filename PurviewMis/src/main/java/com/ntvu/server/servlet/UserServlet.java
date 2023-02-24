package com.ntvu.server.servlet;

import com.ntvu.server.entity.user;
import com.ntvu.server.servlet.db.DBManager;
import com.ntvu.util.webtools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        switch (action) {
            case "add": {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String passwordTwo = req.getParameter("password2");
                String realname = req.getParameter("realname");
                String sex = req.getParameter("sex");
                String age = req.getParameter("age");
                String telephone = req.getParameter("telephone");
                String email = req.getParameter("email");
                String salt = "salt";

                if (username == null || username.equals("")) {
                    System.out.println("0");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (password == null || password.equals("") || !(password.length() >= 6 && password.length() <= 32)) {
                    System.out.println("1");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (!password.equals(passwordTwo)) {
                    System.out.println("2");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (realname == null || realname.equals("")) {
                    System.out.println("3");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (email == null || email.equals("")) {
                    System.out.println("4");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (telephone == null || telephone.equals("")) {
                    System.out.println("5");
                    resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                    return;
                }
                if (age == null || age.equals("")) {
                } else {
                    try {
                        Integer.parseInt(age);
                    } catch (Exception e) {
                        System.out.println("6");
                        resp.sendRedirect(req.getContextPath() + "/user/userServlet??action=add");
                        return;
                    }
                }
                user user = new user();
                user.setUsername(username);
                user.setPasword(webtools.md5(password));
                user.setRealname(realname);
                user.setSex(sex.equals("1"));
                user.setAge(Integer.parseInt(age));
                user.setTelephone(telephone);
                user.setEmail(email);
                user.setSalt(salt);
                boolean flag = new DBManager().register(user);
                if (flag) {
                    resp.sendRedirect(req.getContextPath() + "/html/list/user_list.jsp");
                    return;
                } else {
                    resp.sendRedirect(req.getContextPath() + "/html/register/register.jsp");
                    return;
                }
            }
            case "login": {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String remember = req.getParameter("remember");
                user user = new DBManager().login(username, webtools.md5(password));
                if (user != null) {//成功
//                    记住密码复选框  勾选按钮将账号密码存入cookie
                    if ("1".equals(remember)) {
                        Cookie cookieUsername = new Cookie("username", username);
                        Cookie cookiePassword = new Cookie("password", password);
//                         设置cookie存储时间
                        cookiePassword.setMaxAge(60 * 60 * 24 * 7);
                        cookieUsername.setMaxAge(60 * 60 * 24 * 7);
//                        设置路径
                        cookieUsername.setPath("/");
                        cookiePassword.setPath("/");
//                     发送到浏览器
                        resp.addCookie(cookiePassword);
                        resp.addCookie(cookieUsername);
                    }


                    HttpSession session = req.getSession();
                    //将用户信息存在session 多个页面共享数据
                    session.setAttribute("user", user);
                    //重定向只跳转不转发数据
                    resp.sendRedirect(req.getContextPath() + "/html/list/user_list.jsp");
                } else {//失败
                    //讲失败信息存在请求中
                    req.setAttribute("error", "用户名或密码错误");
//                    将请求的数据转发到login页面，仅使用一次
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
            default: {
                break;
            }
        }
    }
}

