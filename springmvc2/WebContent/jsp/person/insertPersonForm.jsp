<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:set var="isModify" value="${not empty person}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${isModify ? 'updatePersonForm' : 'insertPersonForm' }</title>
</head>
<body>
	<form action="${isModify ? '/person/updatePersonProc.do' : '/person/insertPersonProc.do' }" method="post">
		아이디: <input type="text" name="pid" placeholder="아이디를 입력하세요" 
			<c:if test="${isModify}">value="${person.pid}" disabled</c:if>
		/><br>
		<c:if test="${isModify}"><input type="hidden" name="pid" value="${person.pid}" /></c:if>
		이름: <input type="text" name="name" placeholder="이름을 입력하세요" 
			<c:if test="${isModify}">value="${person.name}"</c:if>
		/><br>
		나이: <input type="text" name="age" placeholder="나이를 입력하세요" 
			<c:if test="${isModify}">value="${person.age}"</c:if>
		/><br>
		<button>${isModify ? '수정' : '등록' }</button>
	</form>
</body>
</html>