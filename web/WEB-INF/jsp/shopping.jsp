<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/1
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="CommonHead.jsp"/>
    <link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">
    <%--    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/goods.css"/>--%>
    <script>
        $(function () {
            $("#goodskind").change(function () {
                if ($("#goodskind").val() == "全部") {
                    window.location.href = "${pageContext.request.contextPath}/user/shopping";
                } else {
                    let selected = $("#goodskind").val();
                    $("#goodsKindForm").submit();
                }
            });
        });

        function addCart(goodsid) {
            $.post("${pageContext.request.contextPath}/user/addCart/" + goodsid, "", function (data) {
                if (data == "success") {
                    alert("加入购物车成功！");
                } else {
                    alert("加入购物车失败！");
                }
            });
        }

    </script>
</head>
<body>
<%--导航栏--%>
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
        <form action="${pageContext.request.contextPath}/user/goodsKind/query" class="form nav-link" id="goodsKindForm">
            <select name="goodskind" id="goodskind" class="custom-select d-block w-100">
                <option value="全部">全部</option>
                <c:forEach items="${sessionScope.goodsKinds}" var="goodsKind">
                    <c:if test="${goodskind == goodsKind.kind}">
                        <option value="${goodsKind.kind}" selected> ${goodsKind.kind}</option>
                    </c:if>
                    <c:if test="${goodskind != goodsKind.kind}">
                        <option value="${goodsKind.kind}"> ${goodsKind.kind}</option>
                    </c:if>
                </c:forEach>
            </select>
        </form>
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
<%--导航栏结束--%>

<div class="container">
    <c:forEach items="${goods}" var="goods">
        <div class="context float-left mr-5 mt-4">
            <img src="${goods.img}" width="300px" height="320px">
            <p>名称：${goods.goodsname}</p>
            <p>价格：${goods.price}</p>
            <p>类型：${goods.kind}</p>
            <p>型号：${goods.model}</p>
            <button class="btn btn-lg btn-primary btn-block mb-2" type="button" onclick="addCart(${goods.goodsid})">
                加入购物车
            </button>
            <a href="${pageContext.request.contextPath}/user/queryInfo/${goods.goodsid}">
                <button class="btn btn-lg btn-primary btn-block" type="button">查看详情</button>
            </a>
        </div>
    </c:forEach>
</div>
</div>

</body>
</html>
