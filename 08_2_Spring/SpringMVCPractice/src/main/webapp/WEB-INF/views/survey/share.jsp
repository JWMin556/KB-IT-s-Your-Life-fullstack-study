<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>설문 공유</title>
</head>
<body>

<h2>[${survey.name}] 님의 설문에 참여해주세요!</h2>
<p>${survey.message}</p>
<p>
    👉 <a href="${survey.link}" target="_blank">${survey.link}</a>
</p>

<p>🔗 다른 친구에게도 공유해보세요!</p>

</body>
</html>
