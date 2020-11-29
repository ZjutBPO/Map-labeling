<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script>
        function a() {
            $.ajax({
                url:"http://localhost:8080/StatisticUserLoc",
                type:"post",
                success:function (result) {
                    alert(result['imsi']);
                }
            })
        }
    </script>
</head>
<body onload="a()">

</body>
</html>
