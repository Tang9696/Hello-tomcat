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
         <h2>shopping page</h2>
         <div style="width:700px;margin-left:auto;margin-right:auto;text-align:center;">
             <c:forEach items="${products}" var="product">

                 <div class="ci">
                     <div class="ck">
                         <img style="width: 200px; height: 140px;" src="${product.images}"data-holder-rendered="true">
                     </div>
                     <div class="cki">
                           <div>Name:${product.name}</div>
                           <div>Price:${product.price}</div>
                           <div>Introduce:${product.introduce}</div>
                     </div>
                           <div class="ckl">
                             <input type="button" onclick="javascript:window.location.href='controller?command=addorder&userid=${user.userid}&proid=${product.id}&price=${product.price}'" value="Order"/>
                             <input type="button" onclick="javascript:window.location.href='controller?command=addcart&userid=${user.userid}&proid=${product.id}'" value="Add Cart"/>
                           </div>

                 </div>

             </c:forEach>
         </div>
     </div>



     </body>
 </html>