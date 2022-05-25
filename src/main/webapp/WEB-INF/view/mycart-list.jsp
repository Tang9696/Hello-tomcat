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

    <div class="list">
        <h2>My Cart list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td style="width:130px;">Product Name</td>
        	<td style="width:90px;">Price</td>
        	<td style="width:180px;">createtime</td>
        	<td style="width:90px;">Editor</td>
        	<td style="width:90px;">Delete</td>

            </thead>



            <c:forEach items="${cart}" var="cart">

            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">
        			<td><div class="tddiv">${cart.product.name}</div></td>
                    <td><div class="tddiv">${cart.product.price}</div></td>
        			<td><div class="tddiv">${cart.createtime}</div></td>


        			<td><div class="tddiv"><a href="controller?command=">Order</a></div></td>
        			<td><div class="tddiv"><a href="controller?command=">delete</a></div></td>
        		</form>
            </tr>
           </tbody>
           </c:forEach>
           </table>
           </div>
           </div>
    </body>
</html>