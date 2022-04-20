<%@ page import="by.bsu.helltom.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
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
    <h2>Personal Information list page</h2>
    <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

            <td style="width:130px;">User Name</td>
            <td style="width:90px;">Phone</td>
            <td style="width:130px;">Recevier</td>
            <td style="width:130px;">Status</td>


            </thead>





                <tbody>
                <tr>
                    <form action="" method="post" style="text-align: center;">
                        <td><div class="tddiv">${user.username}</div></td>
                        <td><div class="tddiv">${user.phone}</div></td>
                        <td><div class="tddiv">${user.recevier}</div></td>
                        <td align="center"><div class="tddiv">
                            <c:if test="${user.status == 1 }">
                                <div style="color:green;">Effective</div>
                            </c:if>
                            <c:if test="${user.status == 0 }">
                                <div style="color:red;">Invalid</div>
                            </c:if></div>
                        </td>
                    </form>
                </tr>
                </tbody>
        </table>
        <div class="add">
            <input type="button" onclick="javascript:window.location.href='controller?command=upinfoindex&id=${user.userid}'" value="Editor"/>
        </div>
    </div>

</div>
</body>
</html>