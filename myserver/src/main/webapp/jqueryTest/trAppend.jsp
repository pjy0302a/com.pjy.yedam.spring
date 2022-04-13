<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<input id="userid">
	<input id="username">
	<input id="sal">
	<button type="button" id="btn">등록</button>
	<table>
		
		<thead>
			<tr><td>이름</td><td>급여</td></tr>
		</thead>
		<tbody>
			<tr data-userid="101"><td>홍길동</td><td>1000</td></tr>
		</tbody>
	</table>
	<script>
		//버튼 클릭 이벤트
 		$("#btn").on("click",function() {
			$("<tr>").append($("<td>").html($("#username").val()))
					.append($("<td>").html($("#sal").val()))
					.data("userid",$("#userid").val())
					.appendTo($("tbody"));
		}) 
		
/* 		$("#btn").on("click",function() {
			let userid= $("#userid").val()
			let username= $("#username").val()
			let sal= $("#sal").val()
			let tr = `<tr data-userid="\${userid}"><td>\${username}</td><td>\${sal}</td></tr>`
			
			$("tbody").append(tr)
		}) */
		
	</script>
</body>
</html>