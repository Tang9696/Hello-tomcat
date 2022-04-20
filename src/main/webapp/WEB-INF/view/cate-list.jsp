 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
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
    <div class="menu">
       <jsp:include page="/WEB-INF/view/main.jsp">
            <jsp:param name="user" value="${user}"/>
       </jsp:include>
    </div>

    <div class="list">
        <h2>Category list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td>TypeName</td>
        	<td>Status</td>
        	<td>createtime</td>
        	<td>updatetime</td>
        	<td style"width:90px;">Editor</td>
        	<td style"width:90px;">Delete</td>

            </thead>



            <c:forEach items="${category}" var="category">

            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">
        			<td>${category.typename}</td>
        			<td>
        			 <c:if test="${category.status == 1 }">
                          <div style="color:green;">Normal</div>
                     </c:if>
                     <c:if test="${category.status == 2 }">
                          <div style="color:red;">Discarded</div>
                     </c:if>

        			</td>
        			<td style="width:90px;">${category.createtime}</td>
        			<td style="width:90px;">${category.updatetime}</td>

        			<td><a href="controller?command=upcateindex&id=${category.categoryid}">editor</a></td>
        			<td > <a onclick="javascript:return change();" href="">delete</a> </td>
        		</form>
            </tr>
           </tbody>
           </c:forEach>
           </table>
           <div class="add">
                <input type="button" onclick="javascript:window.location.href='controller?command=addcateindex'" value="Add Category"/>
           </div>
           </div>
           </div>
    </body>
</html>