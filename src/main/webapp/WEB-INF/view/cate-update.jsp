<%@ page import="by.bsu.helltom.entity.Category" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    Category category = (Category) request.getAttribute("category");
%>
<div class="menu">
    <jsp:include page="/WEB-INF/view/main.jsp">
        <jsp:param name="user" value="${user}"/>
    </jsp:include>
</div>

<div class="list">
    <h2>update category page</h2>
    <div class="center5">
        <form action="controller?command=upcate" method="post" style="margin: auto auto; text-align: center;">

            <div style ="display:none">
                <input type="text" value="${category.categoryid}" name="id"/>
            </div>

            <p><span>TypeName:</span></p>
            <input type="text" value="${category.typename}" name="typename"/>

            <br/>

            <p><input type="submit" value="submit"/></p>

        </form>
    </div>
</div>
</body>
</html>