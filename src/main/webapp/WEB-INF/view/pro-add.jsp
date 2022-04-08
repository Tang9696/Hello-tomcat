<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
        <h2>add product page</h2>
        <div class="center2">
        <form action="controller?command=addpro" method="post" style="margin: auto auto; text-align: center;">
                <p><span>cate_proid:</span></p>
                <input type="text" name="cate_proid"/>

        <br/>

                <p><span>name:</span></p>
                <input type="text" name="name"/>

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
    </body>
</html>