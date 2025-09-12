<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listPerson</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${personList}">
			<tr>
				<td>
					<a href="/person/getPerson.do?pid=${person.pid}">${person.pid}</a>
				</td>
				<td>${person.name}</td>
				<td>${person.age}</td>
				<td>
					<a href="/person/updatePersonForm.do?pid=${person.pid}">수정</a>
				</td>
				<td>
					<a href="/person/deletePerson.do?pid=${person.pid}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/person/insertPersonForm.do">등록</a>
</body>
</html>