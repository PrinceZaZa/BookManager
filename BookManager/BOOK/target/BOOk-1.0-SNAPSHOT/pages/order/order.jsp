<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的订单</title>
	<%--静态包含，头部引用信息--%>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png">
	<span class="wel_word">我的订单</span>
	<%--静态包含，登录 成功之后的菜单 --%>
	<%@ include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

	<table>
		<tr>
			<td>日期</td>
			<td>金额</td>
			<td>状态</td>
			<td>详情</td>
		</tr>

		<c:if test="${empty requestScope.orders}">
			<tr>
				<td colspan="4"><a href="index.jsp">没有任何订单哦！</a></td>
			</tr>
		</c:if>
		<%--订单不为空时--%>
		<c:if test="${not empty requestScope.orders}">
			<c:forEach items="${requestScope.orders}" var="order">
				<tr>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td>
						<c:if test="${order.status==0}">
							<span>未发货</span>
						</c:if>
						<c:if test="${order.status==1}">
							<span>已发货</span>
						</c:if>
						<c:if test="${order.status==2}">
							<span>已收货</span>
						</c:if>
					</td>
					<td><a href="orderServlet?action=orderDetail&orderId=${order.orderId}">查看详情</a></td>
				</tr>
			</c:forEach>
		</c:if>


	</table>


</div>

<%--静态包含，脚部信息--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>