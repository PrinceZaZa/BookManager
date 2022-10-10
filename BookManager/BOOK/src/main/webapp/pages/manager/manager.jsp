<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">后台管理系统</span>
    <c:if test="${sessionScope.user.username.equalsIgnoreCase('admin')}">
        <%@ include file="/pages/common/manager_menu.jsp" %>
    </c:if>

</div>

<c:if test="${sessionScope.user.username.equalsIgnoreCase('admin')}">
    <div id="main">
        <h1>欢迎管理员进入后台管理系统</h1>
    </div>
</c:if>

<c:if test="${!sessionScope.user.username.equalsIgnoreCase('admin')}">
    <div id="main">
        <h1>你不是管理员，不能进入后台</h1>
        <h1>管理员账号：admin,密码：admin</h1>
    </div>
</c:if>


<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>