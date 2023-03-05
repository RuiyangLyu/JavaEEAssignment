<%@ page import="java.io.PrintWriter" %>
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

    <h2>登录</h2>
    <form action="LoginServlet">
        用户名：<input name="username" type="text"> <br>
        密码框：<input name="password" type="password"> <br>
        <button type="submit">提交</button>
        <%--        <button type="reset">重置</button>--%>
    </form>
    <span class="msg"><%=msg%></span>
</body>
</html>
