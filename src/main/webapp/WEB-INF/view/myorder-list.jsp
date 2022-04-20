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
        <h2>My Order list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td>Order Num</td>
        	<td>Recevier</td>
        	<td>Payment</td>
        	<td>Status</td>
        	<td>Createtime</td>
        	<td style="width:90px;">Editor</td>
        	<td style="width:90px;">Delete</td>

            </thead>



            <c:forEach items="${orderitem}" var="Orderitem">

            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">

        			<td><div class="tddiv">${Orderitem.order.ordernumber}</div></td>
        			<td><div class="tddiv">${Orderitem.user.recevier}</div></td>
        			<td><div class="tddiv">${Orderitem.order.payment}</div></td>
        			<td><div class="tddiv">
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
                     </c:if></div>
                     </td>
        			<td style="width:90px;"><div class="tddiv">${Orderitem.order.createtime}</div></td>


        			<td><div class="tddiv">
                        <c:if test="${Orderitem.order.status == 20 || Orderitem.order.status == 30 || Orderitem.order.status == 0}">
                            <a href="">Check</a>
                        </c:if>
                        <c:if test="${Orderitem.order.status == 10 }">
                            <a href="">Pay</a>
                        </c:if></div>
                    </td>
        			<td > <div class="tddiv"><a onclick="javascript:return change();" href="">Cancel</a> </div></td>
        		</form>
            </tr>
           </tbody>
           </c:forEach>
           </table>
           </div>
           </div>
    </body>
</html>