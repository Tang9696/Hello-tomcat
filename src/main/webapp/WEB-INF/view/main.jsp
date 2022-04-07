 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

    <body>
    <h2>Hello</h2>
    <c:if test="${user != null}">
    <div class="center">
    <p><a href="controller?command=bookList">Book list</a></p>
    <br/>
    <p><a href="controller?command=addproindex">Add product</a></p>
    <br/>
      <c:if test="${user.username == 'admin' }">
            <p><a href="controller?command=">User</a></p>
            <br/>
      </c:if>
    <p><a href="controller?command=logout">Logout</a></p>
    </div>
    </c:if>
    </body>
</html>