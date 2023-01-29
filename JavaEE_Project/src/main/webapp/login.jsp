<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 10314
  Date: 2022/12/8
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    System.out.println(msg);
    if (msg == null){
        msg="";
    }
%>
    <span class="msg"><%=msg%></span>
    <h2>登录</h2>
    <form action="LoginServlet">
        用户名：<input name="username" type="text">
        密码：<input name="password" type="password">
        <button type="submit">提交</button>
<%--        <button type="reset">重置</button>--%>
    </form>
</body>
</html>
