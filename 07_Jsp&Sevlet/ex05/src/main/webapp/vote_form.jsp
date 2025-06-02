<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 4.
  Time: 오후 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>우리 반 인기 간식 투표</title>
</head>
<body>
  <h1>우리 반 인기 간식 투표</h1>

  <%--   최근 간식 출력--%>
  <c:if test="${not empty lastSnack}">
    <p>
      최근에 고른 간식: <strong>${lastSnack}</strong><br>
      이 간식을 다시 드셔보는 건 어떠세요?
    </p>
  </c:if>

  <%--  최근 방문 시간 출력--%>
  <c:if test="${not empty sessionScope.visitTime}">
    <p>
      최근 방문 시간: ${sessionScope.visitTime}
    </p>
  </c:if>

  <form action="/vote-submit" method="post">
    <fieldset>
      <legend>좋아하는 간식을 선택하세요</legend>
      <label><input type="radio" name="snack" value="와사비과자"> 와사비과자</label><br>
      <label><input type="radio" name="snack" value="붕어빵"> 붕어빵</label><br>
      <label><input type="radio" name="snack" value="초코파이"> 초코파이</label><br>
      <label><input type="radio" name="snack" value="감자칩"> 감자칩</label><br>
      <label><input type="radio" name="snack" value="마시멜로"> 마시멜로</label><br>
      <label><input type="radio" name="snack" value="쿠키"> 쿠키</label><br>
      <label><input type="radio" name="snack" value="떡볶이"> 떡볶이</label><br>
      <label><input type="radio" name="snack" value="초콜릿"> 초콜릿</label><br>
      <label><input type="radio" name="snack" value="젤리"> 젤리</label><br>
    </fieldset>

    <button type="submit">투표하기</button>
  </form>

  <form action="/reset" method="get">
    <button type="submit">초기화</button>
  </form>
</body>
</html>
