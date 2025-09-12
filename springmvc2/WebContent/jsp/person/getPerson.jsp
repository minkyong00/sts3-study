<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getPerson</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${person.pid}</td>
				<td>${person.name}</td>
				<td>${person.age}</td>
			</tr>
		</tbody>
	</table>
	<a href="/person/listPerson.do">목록으로</a>
</body>
</html>