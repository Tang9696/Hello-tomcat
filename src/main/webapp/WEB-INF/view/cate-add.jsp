<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
        <div class="menu">
           <jsp:include page="/WEB-INF/view/main.jsp">
                <jsp:param name="user" value="${user}"/>
           </jsp:include>
        </div>

        <div class="list">
        <h2>add category page</h2>
        <div class="center5">
        <form action="controller?command=addcate" method="post" style="margin: auto auto; text-align: center;">


                <p><span>TypeName:</span></p>
                <input type="text" name="typename"/>

        <br/>

                <p><input type="submit" value="submit"/></p>

        </form>
        </div>
        </div>
    </body>
</html>