<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/2
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css"/>
    <jsp:include page="CommonHead.jsp"/>
    <script>
        let str="";
        $(function (){
            $(".custom-checkbox").click(function (){
                str+="goodsid="+this.value+"&"
            })
        })
        $(function (){
            $("#submit").click(function (){
                let index = str.lastIndexOf("&");
                let s = str.substring(0,index);
                $.post("${pageContext.request.contextPath}/user/payment",s,function (data){
                    if (data != 0){
                        if (confirm("一共"+data+"您确定现在付款么？")){
                            window.location.href="${pageContext.request.contextPath}/user/toPay";
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<jsp:include page="commonNav.jsp"/>
<div>
    <table class="list">
        <tr class="list_name">
            <td>操&nbsp;&nbsp;作</td>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品数量</td>
        </tr>
        <c:forEach items="${goods}" var="goods">
            <tr class="mb-3">
                <td>
                    <input type="checkbox" name="check" class="custom-checkbox" value="${goods.goodsid}">
                </td>
                <td><img src="${goods.img}" class="goods_img"></td>
                <td>${goods.goodsname}</td>
                <td>${goods.price}</td>
                <td>${goods.cnt}</td>
            </tr>
            <tr>
                <td colspan="5">
                    <hr>
                </td>
            </tr>
        </c:forEach>

        <tr align="center">
            <td colspan="5">
                <button class="btn btn-lg btn-primary btn-block" type="button" id="submit">结算</button>
            </td>
        </tr>
    </table>

</div>
</body>
</html>

