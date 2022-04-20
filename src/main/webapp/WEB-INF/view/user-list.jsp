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
        <h2>User list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td>name</td>
        	<td>phone</td>
        	<td>recevier</td>
        	<td>ststus</td>
        	<td width="20%">createtime</td>
        	<td width="20%">updatetime</td>
        	<td width="20%" align="center">Check</td>
        	<td width="20%" align="center">Cancel</td>

            </thead>



            <c:forEach items="${users}" var="user">

            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">
        			<td align="center">${user.username}</td>
        			<td align="center">${user.phone}</td>
        			<td align="center">${user.recevier}</td>
        			<td align="center">
        			   <c:if test="${user.status == 1 }">
        			       <div style="color:green;">Effective</div>
        			   </c:if>
        			   <c:if test="${user.status == 0 }">
                           <div style="color:red;">Invalid</div>
                       </c:if>
        			</td>
        			<td width="20%" align="center">${user.createtime}</td>
        			<td width="20%" align="center">${user.updatetime}</td>
        			<td width="20%" align="center"><a href="">Check</a></td>
        			<td width="20%" align="center"> <a onclick="javascript:return change();" href="">Cancel</a> </td>
        		</form>
            </tr>
           </tbody>
           </c:forEach>
           </table>
           </div>
           </div>

    </body>
</html>