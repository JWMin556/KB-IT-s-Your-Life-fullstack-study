<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 5. 29.
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>스크립트릿 실습</title>
</head>
<body>
  <h1>현재 날짜 출력 실습</h1>
  <%
    Date d = new Date();  //인텔리제이가 자동으로 임포트 해줌
    Date d2 = null;
  %>
  현재 날짜: <%= d %>
</body>
</html>
