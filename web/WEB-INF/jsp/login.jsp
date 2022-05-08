<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/4/29
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <jsp:include page="CommonHead.jsp"/>
    <script>
        function errorMsg() {
            if (${requestScope.containsKey("errorMsg")}) {
                alert("${requestScope.errorMsg}");
            }
        }

        $(function () {
            $("#admin").click(function () {
                $.post("${pageContext.request.contextPath}/user/autoLogin", "", function (data) {
                    $("#username").val(data.adminname);
                    $("#password").val(data.password);
                })
            });
        })
    </script>
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
</head>
<body class="text-center" onload="errorMsg()">
<div class="mycenter">
    <form class="form-signin" action="${pageContext.request.contextPath}/user/doLogin" method="post">
        <img class="mb-4" src="${pageContext.request.contextPath}/img/icon.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
        <label for="username" class="sr-only">手机号</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="username" required autofocus
               autocomplete="off">
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <div class="form-group"><input type="checkbox" name="admin" id="admin" class="float-left mt-2"> <small
                class="mt-1 float-left" style="vertical-align: center"><label for="admin">管理员登录</label></small></div>
    </form>
</div>

</body>
</html>
