<%@ page import="by.bsu.helltom.entity.Category" %>
<%@ page import="by.bsu.helltom.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<div class="menu">
    <jsp:include page="/WEB-INF/view/main.jsp">
        <jsp:param name="user" value="${user}"/>
    </jsp:include>
</div>

<div class="list">
    <h2>Update Personal Information Page</h2>
    <div class="center5">
        <form action="controller?command=upmyinfo" method="post" style="margin: auto auto; text-align: center;">

            <div style ="display:none">
                <input type="text" value="${user.userid}" name="id"/>
            </div>

            <p><span>UserName:</span></p>
            <input type="text" value="${user.username}" name="username"/>

            <br/>

            <p><span>Phone:</span></p>
            <input type="text" value="${user.phone}" name="phone"/>

            <br/>

            <p><span>Recevier:</span></p>
            <input type="text" value="${user.recevier}" name="recevier"/>

            <br/>

            <p><input type="submit" value="submit"/></p>

        </form>
    </div>
</div>
</body>
</html>