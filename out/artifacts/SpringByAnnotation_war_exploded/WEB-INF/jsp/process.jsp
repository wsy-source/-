<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/5/1
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理订单</title>
    <jsp:include page="CommonHead.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/process.css">
    <script>
        $("#upd").click(function (){
            alert("修改成功!");
        });
    </script>
</head>
<body>
    <jsp:include page="commonNav.jsp"/>
    <div  class="container-fluid back">
        <p>&nbsp;</p>
       <div class="container">
           <div class="center">
           <img src="${pageContext.request.contextPath}/img/icon.png" style="margin-left: 180px" width="60" height="60">
           <form action="${pageContext.request.contextPath}/admin/process" role="form" class="form" method="post">
               <table class="ml-5 mt-4">
                   <div class="form-group ">
                       <tr >

                           <td><input type="hidden"  name="ordid" id="ordid" class="form-control" value="${order.ordid}" ></td>
                       </tr>
                   </div>
                   <div class="form-group ">
                       <tr >
                           <td><label for="goodsname">商品名:</label></td>
                           <td><input type="text"  id="goodsname" class="form-control" value="${order.goodsname}" disabled ></td>
                       </tr>
                   </div>
                   <div class="form-group mb-4">
                       <tr >
                           <td><label for="cnt">数量:</label></td>
                           <td><input type="text"  id="cnt" class="form-control" value="${order.cnt}" disabled></td>
                       </tr>
                   </div>
                   <div class="form-group mb-4">
                       <tr >
                           <td><label for="username">收件人:</label></td>
                           <td><input type="text" id="username" class="form-control" value="${order.username}" disabled ></td>
                       </tr>
                   </div>
                   <div class="form-group mb-4">
                       <tr >
                           <td><label for="tel">联系电话:</label></td>
                           <td><input type="number"  id="tel" class="form-control" value="${order.tel}" disabled ></td>
                       </tr>
                   </div>
                   <div class="form-group mb-4">
                       <tr>
                           <td><label for="address">地址:</label></td>
                           <td><input type="text" name="address" id="address" class="form-control" value="${order.address}"></td>
                       </tr>
                   </div>
                   <div class="form-group mb-4">
                       <tr>
                           <td><label for="status">状态修改:</label></td>
                           <td>
                               <select name="state" id="status" class="custom-select">
                                   <option value="2">已发货</option>
                                   <option value="3">已收货</option>
                               </select>
                           </td>
                       </tr>
                   </div>
                   <tr>
                       <td colspan="2">
                           &nbsp;
                       </td>
                   </tr>
                   <tr>
                       <td colspan="2">
                           <button class="btn btn-lg btn-primary btn-block" type="submit" id="upd">确认修改</button>
                       </td>
                   </tr>

                   <tr>
                       <td colspan="2">
                           <a href="${pageContext.request.contextPath}/admin/manage"> <button class="btn btn-lg btn-primary btn-block" type="submit">返回</button></a>
                       </td>
                   </tr>
               </table>
           </form>
       </div></div>
    </div>
</body>
</html>
