<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--将地址设置为动态的--%>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basePath);
%>

<!--写base标签，动态获取路径-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

