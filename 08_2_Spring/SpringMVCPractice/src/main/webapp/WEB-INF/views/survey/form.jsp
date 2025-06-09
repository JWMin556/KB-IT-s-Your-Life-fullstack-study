<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/survey" method="POST">
    이름: <input type="text" name="name" required><br><br>
    설문 링크 (Mentimeter): <input type="url" name="link" required><br><br>
    유도 멘트: <input type="text" name="message" required><br><br>
    <button type="submit">공유 페이지 생성</button>
  </form>
</body>
</html>
