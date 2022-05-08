<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/2
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <jsp:include page="CommonHead.jsp"/>
    <link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">
    <script>
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
<jsp:include page="commonNav.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-7">
            <h2 class="featurette-heading">${goodsInfo.goodsname}</h2>
            <p class="lead mt-4"><span>种类:</span>${goodsInfo.kind}</p>
            <p class="lead mt-4"><span>型号:</span>${goodsInfo.model}</p>
            <p class="lead mt-4"><span>价格:</span><span style="color: orangered">${goodsInfo.price}</span></p>
            <p class="lead mt-4"><span>描述:</span>${goodsInfo.detail}</p>
            <p class="lead mt-4">
                <button class="btn btn-lg btn-primary btn-block" type="button" style="width: 380px"
                        onclick="addCart(${goodsid})">加入购物车
                </button>
            </p>
            <p class="lead mt-4">
                <a href="${pageContext.request.contextPath}/user/shopping">
                    <button class="btn btn-lg btn-primary btn-block" type="button" style="width: 380px">返回商城</button>
                </a>
            </p>


        </div>

        <div class="col-md-5 order-md-1 mt-5 ">
            <img src="${goodsInfo.img}"
                 class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500"
                 height="500">
        </div>
    </div>
</div>

</body>
</html>
