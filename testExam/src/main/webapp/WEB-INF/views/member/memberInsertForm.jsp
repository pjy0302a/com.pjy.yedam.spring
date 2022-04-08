<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>회원가입</h1>
	</div>
	<div align="center">
		<form action="memberInsert.do" id="frm" method="post">
			<div>
				<table border="1">

					<tr>
						<th>아이디</th>
						<td><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="password" name="password"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="address" name="address"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" id="tel" name="tel"></td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="글 등록">&nbsp;&nbsp;
				<input type="reset" value="취 소">&nbsp;&nbsp;				
				<input type="button" value="목록가기" onclick="location.href='memberSelectList.do'">&nbsp;&nbsp;				
				<input type="button" value="홈 가기" onclick="location.href='home.do'">&nbsp;&nbsp;				
			</div>
		</form>
	</div>
</body>
</html>