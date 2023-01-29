
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>修改水闸信息</h1>

<form action="ModifyGateServlet" method="post">
    <input type="text" name="id" value="${id}" hidden><br>
    编号：<span>${id}</span><br>
    水闸名：<input type="text" name="gatename" value="${gatename}"><br>
    建成时间：<input type="text" name="buildtime" value="${buildtime}"><br>
    负责人：<input type="text" name="manager" value="${manager}"><br>
    经度：<input type="text" name="latitude" value="${lat}"><br>
    纬度：<input type="text" name="longitude" value="${lng}"><br>
    简介：<br>
    <textarea name="description" rows="5" cols="70">${description}</textarea><br>


    <input type="submit" value="修改">
    <button type="button" class="backBtn">取消</button>
</form>
<script>
    document.querySelector('.backBtn').addEventListener('click',function (){
        window.location.href='main.jsp'

    })
</script>
</body>
</html>
