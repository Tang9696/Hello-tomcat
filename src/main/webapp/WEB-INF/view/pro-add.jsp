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
        <h2>add product page</h2>
        <div class="center2">
        <form action="controller?command=addpro" method="post" enctype="multipart/form-data" style="margin: auto auto; text-align: center;">
                <p><span>category:</span></p>
             <select name="cate_proid">
                <c:forEach items="${category}" var="category">
                        <option value="${category.categoryid}">${category.typename}</option>
                </c:forEach>
             </select>

        <br/>

                <p><span>name:</span></p>
                <input type="text" name="name"/>

        <br/>
                <p><span>image:</span></p>
                <input type="file" name="images"/>

            <br/>

                <p><span>introduce:</span></p>
                <textarea name="introduce"></textarea>

        <br/>

                <p><span>price:</span></p>
                <input type="text" name="price"/>

        <br/>

                <p><span>stock:</span></p>
                <input type="text" name="stock"/>

        <br/>

                <p><input type="submit" value="submit"/></p>

        </form>
        </div>
        </div>
    </body>
</html>