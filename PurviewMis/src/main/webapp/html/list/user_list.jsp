<%@ page import="com.ntvu.server.entity.user" %>
<%@ page import="com.ntvu.server.servlet.db.DBManager" %>
<%@ page import="com.ntvu.server.pager.pagerHelper" %>
<%@ page import="com.ntvu.util.webtools" %><%--
  Created by IntelliJ IDEA.
  User: d
  Date: 2023/2/20
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户列表</title>
    <link rel="stylesheet" href="../../css/listCss.css">
    <script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/js/pager.js"></script>
  </head>
  <body>
  <%
    pagerHelper<user> pager = new pagerHelper(request);
    new DBManager().getList(pager);
  %>
  <table>
  <caption>${user.username},欢迎你</caption>
  <thead>
  <tr>
    <th>学号</th>
    <th>真实姓名</th>
    <th>邮箱</th>
    <th>手机号</th>
    <th>性别</th>
    <th>年龄</th>
  </tr>
  </thead>
    <tbody>
    <%
      for (user user : pager.getData()) {
    %>
    <tr>
      <th><%= user.getUsername()%></th>
    <th><%= user.getRealname()%></th>
    <th><%= user.getEmail()%></th>
    <th><%= user.getTelephone()%></th>
    <th><%= webtools.parseBoolean(user.isSex(), "男", "女")%></th>
    <th><%= webtools.parseNullOrEmpty(user.getAge())%></th>
    </tr>
    <% }%>
    </tbody>
    <tfoot>
    <tr>
    <td colspan="6">
      共有<span ><%= pager.getRecordCount()%></span>条数据，
      每页显示<span ><%= pager.getPageSize()%></span>条，
      当前是<span ><%= pager.getPageIndex()%>/<%= pager.getPageCount()%></span>，
      <span  onclick="doPager(1)" >首页</span>，
      <span  onclick="doPager(<%= pager.getPageIndex() >1? pager.getPageIndex()-1:1 %>)" >上一页</span>，
      <span  onclick="doPager(<%= pager.getPageCount()<=pager.getPageIndex()? pager.getPageCount():pager.getPageIndex()+1 %>)" >下一页</span>,
      <span  onclick="doPager(<%= pager.getPageCount()%>)" >末页</span>
    </td>
    </tr>
    </tfoot>
  </table>
  </body>
</html>
