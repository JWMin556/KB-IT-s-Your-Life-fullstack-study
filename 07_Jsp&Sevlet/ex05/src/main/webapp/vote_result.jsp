<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 4.
  Time: 오후 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>투표 결과</title>
</head>
<body>
  <h1>🎉 투표 완료!</h1>
  <p>
    <strong>
      <c:out value="${snack}" />
    </strong>
  </p>
  <a href="/vote-form">다시 투표하러 가기</a>
</body>
</html>
