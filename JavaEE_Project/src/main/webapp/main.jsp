<%@ page import="Entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<style>
    .loginout{
        margin-left: 90px;
        margin-top: 26px;
    }
</style>
    <header>
    <%
        User user = (User) session.getAttribute("user");
        System.out.println(user);
    %>
        <div style="display: flex">
        <h2 >欢迎回来，用户<%=user.getUsername()%></h2>
    <a class="loginout" href="LogoutServlet">登出系统</a>
        </div>
    </header>

<main>

    <table>
        <thead>
            <th>水闸名</th>
            <th>id</th>
            <th>建成时间</th>
            <th>负责人</th>
            <th>操作</th>
        </thead>
        <tbody id="tbody-List">

        </tbody>
    </table>

    <a href="addGate.jsp">新建闸站</a>
</main>
    <script type="text/javascript" src="commons/js/jquery-3.2.1.min.js"></script>
    <script>
        var courseListBody = document.getElementById("tbody-List");

        $.ajax({
            //发送请求的地址
            url:"GetGatesServlet",
            //请求方式，默认为get
            type:"post",
            //预期服务器返回的数据类型。如果不指定自动根据MIME类型返回信息
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            //发送到服务器的数据，与第26行可选
            data:{},
            //还可以提交整个form表单，注意表单参数的id和name相同，与第18行可选
            //data: $("#myForm").serializeArray(),

            //请求成功后回调函数，参数为服务器返回的数据
            success:function(data){
                //将JSON文本转换为JavaScript对象
                console.log(data)
                var wgList = data;
                var rows = "";
                for(var i=0; i< wgList.length; i++){
                    var waterGate = wgList[i];
                    rows += "<tr>"

                    //课程基本信息单元格
                    rows += "<td>" + waterGate.sluiceName + "</td>";
                    rows += "<td>" + waterGate.id + "</td>";
                    rows += "<td>" + waterGate.completionTime + "</td>";
                    rows += "<td>" + waterGate.chargeRole + "</td>";
                    //操作单元格
                    rows += "<td>";
                    rows += "<a href='ShowModifyGateServlet?id=" + waterGate.id + "'>修改</a>";
                    rows += "&nbsp;&nbsp;";
                    rows += "<a onclick='deleteMsg()' href='DeleteGateServlet?id=" + waterGate.id + "'>删除</a>";
                    rows += "</td>";

                    rows += "</tr>"
                }

                courseListBody.innerHTML = rows;
            },
            // 请求失败时调用的函数
            // error:function(){
            //     alert("处理异常");
            // }
        });

        function deleteMsg(){
            confirm("确定删除吗")
        }

    </script>
</body>
</html>
