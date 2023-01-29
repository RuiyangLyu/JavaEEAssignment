
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("error msg");
    System.out.println(msg);
    if (msg == null){
        msg="";
    }
%>
<span class="msg"><%=msg%></span>
<h1>新建课程页面</h1>
<form action="AddGateServlet" method="post">
    编号：<input type="text" name="id" value="${id}"><br>
    水闸名：<input type="text" name="gatename" value="${gatename}"><br>
    建成时间：<input type="text" name="buildtime" value="${buildtime}"><br>
    负责人：<input type="text" name="manager" value="${manager}"><br>
    经度：<input type="text" name="latitude" value="${lat}"><br>
    纬度：<input type="text" name="longitude" value="${lng}"><br>
    简介：<br>
    <textarea name="description" rows="5" cols="70">${description}</textarea><br>
    <input type="submit" value="提交">
    <button type="button" class="backBtn">取消</button>
</form>

<script>
    document.querySelector('.backBtn').addEventListener('click',function (){
        window.location.href='main.jsp'

    })
</script>
</body>
</html>
