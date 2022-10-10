<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%--静态包含，头部引用信息--%>
    <%@include file="/pages/common/head.jsp" %>

</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word">订单详情</span>
    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>

        </tr>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">

            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>

        </c:forEach>

    </table>

    <div class="cart_info" style="float: right;text-align: left">
        <div class="cart_span">订单编号<span class="b_count">${requestScope.order.orderId}</span></div>
        <div class="cart_span">实际付款<span class="b_price">${requestScope.order.price}</span>元</div>
        <div class="cart_span">交易时间<span class="b_count">${requestScope.order.createTime}</span></div>
        <div class="cart_span">订单状态
            <span class="b_count">
                <c:if test="${requestScope.order.status==0}">
                    <span>未发货</span>
                    <a href="#">提醒发货</a>
                </c:if>
                <c:if test="${requestScope.order.status==1}">
                    <span>已发货</span>
                    <a href="orderServlet?action=orderReceive&orderId=${requestScope.order.orderId}">确认收货</a>
                </c:if>
                <c:if test="${requestScope.order.status==2}">
                    <span>已收货</span>
                </c:if>
            </span>
        </div>
        <div class="cart_span"><a href="">联系卖家</a></div>
    </div>


</div>

<%--静态包含，脚部信息--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>