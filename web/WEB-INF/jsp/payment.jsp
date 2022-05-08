<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/2
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>付款界面</title>
    <jsp:include page="CommonHead.jsp"/>
    <script>
       $(function (){
           $("#payment").click(function () {
               alert("欢迎下次光临你的杂货店");
               $.post("${pageContext.request.contextPath}/user/paymentSuccess", "",function (){
                   alert("123")
               });
               window.location.href = "${pageContext.request.contextPath}/user/shopping";
           });
       })
    </script>
</head>
<body>
<jsp:include page="commonNav.jsp"/>

<div class="container-fluid" style="background-color: #57AB6D;">
    <div>&nbsp;</div>
    <div class="container">
        <div style="margin-top: 100px;margin-left: 350px;width: 420px;height: 537px">
            <img src="${pageContext.request.contextPath}/img/payment.png">
            <a href="${pageContext.request.contextPath}/user/paymentSuccess">
                <button class="btn btn-lg btn-primary btn-block" type="button" style="width: 420px;" id="payment">付款成功</button>
            </a>

        </div>
    </div>
</div>


</body>
</html>
