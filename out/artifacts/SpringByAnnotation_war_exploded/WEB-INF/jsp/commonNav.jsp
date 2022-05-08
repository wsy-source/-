<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/4/30
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div class="container-fluid background">
    <nav class="nav">
        <a class="nav-link " href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/img/icon.png" height="40">
        </a>
        <a class="nav-link active" href="${pageContext.request.contextPath}/">首页</a>
        <a class="nav-link" href="${pageContext.request.contextPath}/user/shopping">商城</a>
        <c:if test="${!sessionScope.containsKey('admin')}">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/cart">购物车</a>
        </c:if>
        <c:if test="${sessionScope.containsKey('admin')}">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/uploadGoods">商品上架</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/manage">订单管理</a>
        </c:if>
        <c:if test="${!(sessionScope.containsKey('user'))}">
            <a class="nav-link " href="${pageContext.request.contextPath}/user/login" id="login">登录</a>
            <a class="nav-link " href="${pageContext.request.contextPath}/user/register" id="register">注册</a>
        </c:if>
        <c:if test="${sessionScope.containsKey('user')}">
            <a class="nav-link " href="">
                <div id="topImg">
                    <img src="${user.photo}" width="48" height="40" style="border-radius: 20px"/>
                    <c:if test="${sessionScope.containsKey('admin')}">
                        <small>${user.adminname}</small>
                    </c:if>
                    <c:if test="${!sessionScope.containsKey('admin')}">
                        <small>${user.username}</small>
                    </c:if>
                </div>
            </a>
        </c:if>

    </nav>
</div>
</body>
</html>
