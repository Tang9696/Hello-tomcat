 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
    <%
        Object message = request.getAttribute("message");
        if(message!=null && !"".equals(message)){

    %>
    <script type="text/javascript">
        alert("<%=request.getAttribute("message")%>");
    </script>
    <%} %>

       <h2>Login Page</h2>
      <div class="center">
      <form action="controller?command=login" method="post">
        <p>username:</p>
        <p><input type="text" name="login"/></p>
        <br/>
        <p>password:</p>
        <p><input type="text" name="password"/></p>
        <br/>
        <input type="submit"/>
      </form>
    <c:if test="${error_message != null}">
        <div class="login-error">
             ${error_message}
        </div>
     </c:if>
     </div>
    </body>
</html>
