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
        <h2>Order list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td>User</td>
        	<td>Order Num</td>
        	<td>Recevier</td>
        	<td>Payment</td>
        	<td>Status</td>
        	<td>Createtime</td>
        	<td style"width:90px;">Editor</td>
        	<td style"width:90px;">Delete</td>

            </thead>



            <c:forEach items="${Orderitem}" var="Orderitem">

            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">
        			<td>${Orderitem.user.username}</td>
        			<td>${Orderitem.order.ordernumber}</td>
        			<td>${Orderitem.user.recevier}</td>
        			<td>${Orderitem.order.payment}</td>
        			<td>
        			 <c:if test="${Orderitem.order.status == 0 }">
                           <div style="color:red;">Canceled</div>
                     </c:if>
                     <c:if test="${Orderitem.order.status == 10 }">
                           <div style="color:red;">Unpaid</div>
                     </c:if>
                     <c:if test="${Orderitem.order.status == 20 }">
                           <div style="color:green;">Paid</div>
                     </c:if>
                     <c:if test="${Orderitem.order.status == 30 }">
                           <div style="color:green;">Finished</div>
                     </c:if>
                     </td>
        			<td style"width:90px;">${Orderitem.order.createtime}</td>


        			<td><a href="">check</a></td>
        			<td > <a onclick="javascript:return change();" href="">Cancel</a> </td>
        		</form>
            </tr>
           </tbody>
           </c:forEach>
           </table>
           </div>
           </div>
    </body>
</html>