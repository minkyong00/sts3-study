<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>파일 업로드 결과</title>
</head>
<body>
  <h1>파일업로드 결과</h1>
  <a href="<c:url value='/fileuploadForm'/>">돌아가기</a>
  <div class="grid">
    <c:forEach var="result" items="${results}">
      <div class="card">
        <p>
        	<strong>${result.originalName}</strong>&nbsp;
			<a href='/filedownload/${fn:substringAfter(result.url, "/uploadfiles/")}'>[다운로드]</a>
        </p>
        <c:choose>
          <c:when test="${not empty result.thumbUrl}">
            <img src="${result.thumbUrl}" alt="thumb" style="max-width: 200px">
          </c:when>
          <c:otherwise>
            ${result.url}
          </c:otherwise>
        </c:choose>
      </div>
    </c:forEach>
  </div>
</body>
</html>
