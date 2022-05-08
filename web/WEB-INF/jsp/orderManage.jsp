<%--
  Created by IntelliJ IDEA.
  User: 10950
  Date: 2022/4/30
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="CommonHead.jsp"/>
</head>
<body>
<jsp:include page="commonNav.jsp"/>
<table class="table ">
    <thead class="thead-dark">
    <tr>
        <th scope="col">订单号</th>
        <th scope="col">商品名</th>
        <th scope="col">数量</th>
        <th scope="col">收件人</th>
        <th scope="col">地址</th>
        <th scope="col">手机号</th>
        <th scope="col">操作</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders.list}" var="order">
    <tr>
        <td>${order.ordid}</td>
        <td>${order.goodsname}</td>
        <td>${order.cnt}</td>
        <td>${order.username}</td>
        <td>${order.address}</td>
        <td>${order.tel}</td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/toProcess?id=${order.ordid}">
                <button type="button" class="btn-success">处理</button>
            </a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%--分页--%>
    <div class="mt-5" style="margin-left:250px ">
        <nav aria-label="...">
            <ul class="pagination">

                <%--                上一页--%>
                <c:if test="${orders.pageNum == 1}">
                    <li class="page-item disabled" id="lastPage">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/manage?pageNum=${orders.pageNum-1}">&lt;</a>
                    </li>
                </c:if>
                <c:if test="${orders.pageNum != 1}">
                    <li class="page-item" id="lastPage">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/manage?pageNum=${orders.pageNum-1}">&lt;</a>
                    </li>
                </c:if>

                <%--                上一页结束--%>

                <c:forEach begin="${1}" end="${orders.pages}" var="num">
                    <c:if test="${orders.pageNum == num}">
                        <li class="page-item active">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/admin/manage?pageNum=${num}">
                                    ${num}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${orders.pageNum != num}">
                        <li class="page-item ">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/admin/manage?pageNum=${num}">
                                    ${num}
                            </a>
                        </li>
                    </c:if>
                </c:forEach>

                <%--                下一页--%>
                <c:if test="${orders.pages == orders.pageNum}">
                    <li class="page-item disabled" id="nextPage">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/manage?pageNum=${orders.pageNum+1}">&gt;</a>
                    </li>
                </c:if>

                <c:if test="${orders.pages != orders.pageNum}">
                    <li class="page-item " id="nextPage">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/manage?pageNum=${orders.pageNum+1}">&gt;</a>
                    </li>
                </c:if>
                <%--                下一页结束--%>
            </ul>
        </nav>
    </div>

</body>
</html>
