<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data" accept-charset="UTF-8">

<%--      여러 파일 업로드시 동일한 이름으로 배열 처리 가능--%>
      <div>
        <input type="file" name="files" />
      </div>
      <div>
        <input type="file" name="files" />
      </div>
      <div>
        <input type="file" name="files" />
      </div>
      <div>
        <input type="file" name="files" />
      </div>
      <div>
        <input type="file" name="files" />
      </div>
      <div>
        <input type="submit" />
      </div>
    </form>
  </body>
</html>