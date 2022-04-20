<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
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
        <h2>update product page</h2>
        <div class="center2">
        <form action="controller?command=uppro" method="post" style="margin: auto auto; text-align: center;">
        <div style ="display:none">
            <input type="text" value="${product.id}" name="id"/>
        </div>
                <p><span>category:</span></p>
             <select name="cate_proid">
                <c:forEach items="${category}" var="category">
                        <option value="${category.categoryid}">${category.typename}</option>
                </c:forEach>
             </select>

        <br/>

                <p><span>name:</span></p>
                <input type="text" value="${product.name}" name="name"/>

        <br/>

                <p><span>introduce:</span></p>
                <textarea value="${product.introduce}" name="introduce"></textarea>

        <br/>

                <p><span>price:</span></p>
                <input type="text" value="${product.price}" name="price"/>

        <br/>

                <p><span>stock:</span></p>
                <input type="text" value="${product.stock}" name="stock"/>

        <br/>

                <p><input type="submit" value="submit"/></p>

        </form>
        </div>
        </div>
    </body>
</html>