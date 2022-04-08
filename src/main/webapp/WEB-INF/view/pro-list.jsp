 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
    <div style="text-align:center;">
        <h2>Book list page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
        <table border="1" >
            <thead align="center">

        	<td>name</td>
        	<td>images</td>
        	<td>price</td>
        	<td>stock</td>
        	<td>createtime</td>
        	<td>updatetime</td>
        	<td style"width:90px;">Editor</td>
        	<td style"width:90px;">Delete</td>

            </thead>



            <c:forEach items="${products}" var="product">


            <tbody>
            <tr>
        	    <form action="" method="post" style="text-align: center;">
        			<td>${product.name}</td>
        			<td><img style="width: 200px; height: 100px;" src="${product.images}"data-holder-rendered="true"></td>
        			<td>${product.price}</td>
        			<td>${product.stock}</td>
        			<td style"width:90px;">${product.createtime}</td>
        			<td style"width:90px;">${product.updatetime}</td>

        			<td><a href="">editor</a></td>
        			<td > <a onclick="javascript:return change();" href="">delete</a> </td>
        		</form>
            </tr>



           </tbody>
           </c:forEach>
           </table>
           </div>
           </div>
    </body>
</html>