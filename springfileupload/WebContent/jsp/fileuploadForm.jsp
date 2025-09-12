<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>멀티 파일 업로드</title>
</head>
<body>
  <h1>멀티 파일 폼</h1>
  <form method="post" action="<c:url value='/fileuploadProc'/>" enctype="multipart/form-data">
    <input type="file" name="files" multiple>
    <button type="submit">업로드</button>
  </form>

  <h2>업로드된 파일 목록</h2>
  <div class="grid">
    <c:forEach var="file" items="${files}">
      <div class="card">
        <a href="${file}" target="_blank">${file}</a>
      </div>
    </c:forEach>
  </div>
</body>
</html>
