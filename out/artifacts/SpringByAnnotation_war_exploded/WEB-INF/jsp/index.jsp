<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  RegisterUser: 10950
  Date: 2022/4/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="CommonHead.jsp"/>
</head>
<body>

    <jsp:include page="commonNav.jsp"/>
    <div class="container">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${pageContext.request.contextPath}/img/lunbotu1.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/img/lunbotu2.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/img/lunbotu3.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </button>
        </div>
    </div>
<%--  <div class="container">--%>
<%--      <img src="img/image2.jpg" class="rounded float-right" alt="...">--%>
<%--      <img src="img/image3.jpg" class="rounded float-left" alt="...">--%>
<%--  </div>--%>
    <div id="lunbotu" class="container">
        <h3>精品推荐</h3>
        <hr>
       <div>
           <div class="card float-left" style="width: 18rem;">
               <img src="${pageContext.request.contextPath}/img/computer1.jpg" class="card-img-top" alt="...">
               <div class="card-body">
                   <h5 class="card-title">惠普笔记本</h5>
                   <p class="card-text">【新品】惠普(HP)VICTUS光影精灵8 16-d1002TX 16.1英寸高清大屏笔记本电脑（Windows11 家庭版/i5-12500H/16G DDR5/512G SSD/RTX3050Ti 4G独显/100%sRGB/DC调光/陨石黑 </p>
               </div>
           </div>
           <div class="card float-left " style="width: 18rem;">
               <img src="${pageContext.request.contextPath}/img/computer1.jpg" class="card-img-top" alt="...">
               <div class="card-body">
                   <h5 class="card-title">惠普笔记本</h5>
                   <p class="card-text">【新品】惠普(HP)VICTUS光影精灵8 16-d1002TX 16.1英寸高清大屏笔记本电脑（Windows11 家庭版/i5-12500H/16G DDR5/512G SSD/RTX3050Ti 4G独显/100%sRGB/DC调光/陨石黑 </p>
               </div>
           </div>
           <div class="card float-left" style="width: 18rem;">
               <img src="${pageContext.request.contextPath}/img/computer1.jpg" class="card-img-top" alt="...">
               <div class="card-body">
                   <h5 class="card-title">惠普笔记本</h5>
                   <p class="card-text">【新品】惠普(HP)VICTUS光影精灵8 16-d1002TX 16.1英寸高清大屏笔记本电脑（Windows11 家庭版/i5-12500H/16G DDR5/512G SSD/RTX3050Ti 4G独显/100%sRGB/DC调光/陨石黑 </p>
               </div>
           </div>
       </div>
        <h3>爆款</h3>
        <hr>
        <div class="card float-left" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/img/phone1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">苹果手机</h5>
                <p class="card-text">Pro 级摄像头系统，能力强悍提升； 显示屏响应之快，让体验全面刷新； 芯片速度再创 iPhone 巅峰； 坚固耐用的设计，出类拔萃； 电池续航更是大步飞跃。
                    来吧，Pro 起来</p>
            </div>
        </div>
        <div class="card float-left" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/img/phone1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">苹果手机</h5>
                <p class="card-text">Pro 级摄像头系统，能力强悍提升； 显示屏响应之快，让体验全面刷新； 芯片速度再创 iPhone 巅峰； 坚固耐用的设计，出类拔萃； 电池续航更是大步飞跃。
                    来吧，Pro 起来</p>
            </div>
        </div>
        <div class="card float-left" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/img/phone1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">苹果手机</h5>
                <p class="card-text">Pro 级摄像头系统，能力强悍提升； 显示屏响应之快，让体验全面刷新； 芯片速度再创 iPhone 巅峰； 坚固耐用的设计，出类拔萃； 电池续航更是大步飞跃。
                    来吧，Pro 起来</p>
            </div>
        </div>
    </div>

</body>
</html>
