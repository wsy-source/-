<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/3
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="CommonHead.jsp"/>
    <link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
    <script>
        // $(function () {
        //     $("#submit").click(function () {
        //         let msg = $("#upload").submit();
        //         // if (msg == "success"){
        //         //     alert("添加成功!");
        //         // }else {
        //         //     alert("添加失败!");
        //         // }
        //     })
        // })
    </script>
</head>
<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/img/icon.png" alt="" width="72"
             height="72">
        <h2>请填写货物信息。</h2>
        <p class="lead">请仔细核对货物详情。</p>
    </div>

    <div class="row">
        <div class="col-md-12 order-md-1">
            <form class="needs-validation" action="${pageContext.request.contextPath}/admin/doUploadGoods"
                  method="post" enctype="multipart/form-data" id="upload">

                <%--                username--%>
                <div class="mb-3">
                    <label for="goodsname">货物名称</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="goodsname" name="goodsname" placeholder="货物名称"
                               autocomplete="off" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="kind">货物种类</label>
                    <div class="input-group">
                        <select class="custom-select d-block w-100" id="kind" name="kind" required>
                            <option value="电脑">电脑</option>
                            <option value="手机" >手机</option>
                            <option value="衣服">衣服</option>
                            <option value="美食">美食</option>
                            <option value="其他">其他</option>
                        </select>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="model">货物型号</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="model" name="model" placeholder="货物型号"
                               autocomplete="off" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="price">货物价格</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="price" name="price" placeholder="货物价格"
                               autocomplete="off" required>
                    </div>
                </div>

                <%--    tel         --%>
                <div class="mb-3">
                    <label for="detail">货物描述</label>
                    <input type="text" name="detail" class="form-control" id="detail" required>
                </div>

                <%--                    手机号--%>
                <div class="mb-3">
                    <label for="picture">photo</label>
                    <input type="file" name="photo" id="picture" class="form-control-file"/>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block mb-4" type="submit" id="submit">提交</button>
            </form>
            <a href="${pageContext.request.contextPath}/admin/manage">
                <button class="btn btn-primary btn-lg btn-block" type="submit">返回</button>
            </a>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
</body>
</html>
