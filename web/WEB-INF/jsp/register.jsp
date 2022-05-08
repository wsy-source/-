<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  RegisterUser: 10950
  Date: 2022/4/30
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/checkout/">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <jsp:include page="CommonHead.jsp"/>
    <script>
        $(function (){
            $("#secondPasswrod").blur(function (){
                let secondPassword = $("#secondPasswrod").val();

                let password = $("#password").val();
                if (password !== secondPassword){
                    alert("两次输入密码不一致！");
                    $("#secondPasswrod").val("");
                    $("#password").val("");
                }
            });
        });
        //手机号格式验证，以及ajax请求判断改手机号是否被注册！
        $(function (){
            $("#tel").blur(function (){
                let tel = $("#tel").val();
                let regex = /^1[3456789]\d{9}$/;
                if (!regex.test(tel)) {
                    alert("手机号码格式有误");
                }else {
                    $.post("${pageContext.request.contextPath}/user/doCheckTel","tel="+tel,function (data){
                        if (data != "success"){
                            alert("改手机号已被注册，请重新输入！");
                            $("#tel").val("");
                        }
                    })
                }
            });
        });
        //用户名验证
        $(function (){
           $("#username").blur(function (){
               let username = $("#username").val();
               $.post("${pageContext.request.contextPath}/user/doCheckUsername","username="+username,function (data){
                   if (data != "success"){
                       alert("改用户名已被注册，请重新输入！");
                       $("#username").val("");
                   }
               });
           });
        })
    </script>
    <link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/img/icon.png" alt="" width="72"
             height="72">
        <h2>请填写个人信息。</h2>
        <p class="lead">请仔细核对收件地址，与个人信息。</p>
    </div>

    <div class="row">
        <div class="col-md-12 order-md-1">
            <form class="needs-validation" action="${pageContext.request.contextPath}/user/doRegister"
                  method="post" enctype="multipart/form-data">

                <%--                username--%>
                <div class="mb-3">
                    <label for="username">用户名</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="username" name="username" placeholder="姓名"
                               autocomplete="off" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">密码</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"></span>
                        </div>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"
                               autocomplete="off" required>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="username">确认密码</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"></span>
                        </div>
                        <input type="password" class="form-control" id="secondPasswrod"  placeholder="请输入密码"
                               autocomplete="off" required>
                    </div>
                </div>

                <%--    tel         --%>
                <div class="mb-3">
                    <label for="tel">电话</label>
                    <input type="number" name="tel" class="form-control" id="tel">
                </div>

                <%--    joinDate--%>
                <div class="mb-3">
                    <label for="joinDate">加入日期</label>
                    <input type="date" class="form-control" id="joinDate" name="joinDate">
                </div>
                <%--    address     --%>
                <div class="row">

                    <div class="col-md-6 mb-3">
                        <label for="address">地址</label>
                        <input type="text" class="form-control" id="address" placeholder="请填写地址" name="address"
                               required>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="defaultAddress">默认地址</label>
                        <select class="custom-select d-block w-100" id="defaultAddress" name="defaultAddress" required>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>

                    </div>
                </div>
                <%--                    手机号--%>
                <div class="mb-3">
                    <label for="picture">photo</label>
                    <input type="file" name="picture" id="picture" class="form-control-file">
                </div>

                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">提交</button>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
</body>
</html>
