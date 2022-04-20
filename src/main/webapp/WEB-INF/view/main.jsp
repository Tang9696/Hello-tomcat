 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

    <body>
    <c:if test="${user != null && user.username == 'admin'}">
       <div class="center4">
          <h2>Hello ${user.username}</h2>
              <div class="center3">
                    <p><a href="controller?command=MPge">Management Page</a></p>
                    <br/>
                    <p><a href="controller?command=orderlist">Order Management</a></p>
                    <br/>
                    <p><a href="controller?command=proList">Product Management</a></p>
                    <br/>
                    <p><a href="controller?command=userList">User Management</a></p>
                    <br/>
                    <p><a href="controller?command=cateList">Categroy Management</a></p>
                    <br/>
                    <p><a href="controller?command=logout">Logout</a></p>
              </div>
       </div>
    </c:if>
    <c:if test="${user != null && user.username != 'admin'}">
           <div class="center4">
              <h2>Hello ${user.username}</h2>
                  <div class="center3">
                        <p><a href="controller?command=shoppingpage">Shopping Page</a></p>
                        <br/>
                        <p><a href="controller?command=mycartList&userid=${user.userid}">My Cart</a></p>
                        <br/>
                        <p><a href="controller?command=myorderList&userid=${user.userid}">My Order</a></p>
                        <br/>
                        <p><a href="controller?command=myinfoList&userid=${user.userid}">Personal Information</a></p>
                        <br/>
                        <p><a href="controller?command=logout">Logout</a></p>
                  </div>
           </div>
        </c:if>
    </body>
</html>