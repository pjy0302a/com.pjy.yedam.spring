<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>게시글 목록</div>
		<div>
		<c:forEach var="notice" items="${notices }">
			<h1>${notice.id }, ${notice.title }</h1>
		</c:forEach>
		</div>
	</div>
</body>
</html>