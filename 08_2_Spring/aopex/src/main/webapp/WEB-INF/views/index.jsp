<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>

    <!-- 💄 Bootstrap 스타일 적용 -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- 🔌 STOMP 클라이언트 CDN -->
    <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>
</head>

<body>
<div id="main-content" class="container">
    <h3>웹소켓 연결하기</h3>

    <div class="row">
        <!-- 👤 사용자 이름 입력 / 연결/끊기 버튼 -->
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">이름: </label>
                    <input type="text" id="name" class="form-control" placeholder="이름을 입력하세요.">
                </div>
                <button id="connect" class="btn btn-default" type="submit">연결</button>
                <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">끊기</button>
            </form>
        </div>

        <!-- 💬 메시지 입력창 -->
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="content">메시지: </label>
                    <input type="text" id="content" class="form-control" placeholder="메시지를 입력하세요...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>

    <br>

    <!-- 🪧 채팅 메시지 테이블 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>채팅 메시지</th>
                </tr>
                </thead>
                <tbody id="chat-messages">
                <!-- 실시간 메시지들이 이곳에 <tr><td>...</td></tr> 형태로 추가됨 -->
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- 🔧 클라이언트 WebSocket 연결 및 전송 로직 -->
<script src="/resources/js/stomp.js"></script>

</body>
</html>