<%--
  Created by IntelliJ IDEA.
  User: localhost
  Date: 17-6-19
  Time: 上午10:18
  To change this template use File | Settings | File Templates.
--%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  System.out.println("Index.jsp");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My first Filter</title>
  </head>
  <body>
  <%
    System.out.println("处理完成");
  %>
  <h1>My first Filter</h1>
  <hr />
  </body>
</html>
