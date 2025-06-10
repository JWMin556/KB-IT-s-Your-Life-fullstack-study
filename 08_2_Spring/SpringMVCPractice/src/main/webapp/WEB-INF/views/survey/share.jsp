<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>설문 공유</title>
</head>
<body>
    <h1>📢 ${survey.name}님의 설문에 참여해주세요!</h1>
    <p><strong>📝 한마디:</strong> ${survey.message}</p>
    <p>👇 아래 링크를 눌러 설문에 참여하세요:</p>
    <p>
        <a href="${survey.link}" target="_blank">${survey.link}</a>
    </p>
    <hr>
    <p>링크를 복사해서 공유하거나, 다른 친구들도 참여하도록 유도해보세요 🎉</p>
</body>
</html>
