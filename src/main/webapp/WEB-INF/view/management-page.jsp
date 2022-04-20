 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
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

          <div class="helloadmin">
             Hello ${user.username} !
          </div>
     </body>
 </html>