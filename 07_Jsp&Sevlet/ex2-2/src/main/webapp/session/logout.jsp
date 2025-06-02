<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 5. 29.
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<%
  session.invalidate();
  response.sendRedirect("loginForm.html");
%>
