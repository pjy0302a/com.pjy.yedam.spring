<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>

<body>
	<div class="container">
		<form id="form1" class="form-horizontal">
			<h2>사용자 등록 및 수정</h2>
			<div class="form-group">
				<label>아이디:</label> <input type="text" class="form-control"
					name="id" id="id">
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control"
					name="name" id="name">
			</div>
			<div class="form-group">
				<label>패스워드:</label> <input type="text" class="form-control"
					name="password" id="password">
			</div>
			<div class="form-group">
				<label>역할:</label> <select class="form-control" name="role">
					<option value="Admin">관리자</option>
					<option value="User">사용자</option>
				</select>
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록"
					id="btnInsert" /> <input type="button" class="btn btn-primary"
					value="수정" id="btnUpdate" /> <input type="button"
					class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<h2>사용자 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">아이디</th>
					<th class="text-center">패스워드</th>
					<th class="text-center">이름</th>
					<th class="text-center">롤</th>
					<th class="text-center"></th>
				</tr>
			</thead>

			<tbody>
				<!-- <tr>
					<td class="text-center">user</td>
					<td class="text-center">1111</td>
					<td class="text-center">홍길동</td>
					<td class="text-center">User</td>
					<td class="text-center">
						<button class="btnUpd">조회</button>
						<button class="btnDel">삭제</button>
					</td>
				</tr> -->

			</tbody>
		</table>
	</div>
<script src="../template/js/json.min.js"></script>
	<script>

		// 등록버튼 : 직접이벤트
		function userInsert() {
			const url = "http://localhost/myserver/users";
			$('#btnInsert').on('click',function(){
				$.ajax({
					url : url,
					type : 'POST',
					contentType : "application/json",
					data : JSON.stringify($("#form1").serializeObject())
				}).done(function(response) {
					$("tbody").prepend(makeTr(response));
				})
			})
		}

		// 수정버튼 : 직접이벤트
		function userUpdate() {
			//버튼 클릭이벤트
			const url = "http://localhost/myserver/users";
			$('#btnUpdate').on('click',function(){
				$.ajax({
					url : url,
					type : 'PUT',
					contentType : "application/json",
					data : JSON.stringify($("#form1").serializeObject())
				}).done(function(response) {
					let newTr = makeTr(response);
					let oldTr = $(this).closest("tr").children().first().html();
					//("[data-id=" + response.id + "]")
					//let oldTr = document.querySelector('[data-id='+user.id+']');
					//$("tbody tr").data('id');
					//console.log(newTr.html());
					console.log(oldTr.html());
					
					//$("tbody").eq(0).replaceChild(newTr,oldTr);
			})
		})
		}
		// 조회버튼 : 그룹이벤트
		function userSelect() {
			$("tbody").on("click",".btnUpd",function(){
			const userid = $(this).closest("tr").children().first().html();
			console.log(userid);
			const url = "http://localhost/myserver/users/" + userid;
			$.ajax({
				url : url,
				type : 'GET'
			}).done(function(response) {
				form1.id.value = response.id;
				form1.password.value = response.password;
				form1.name.value = response.name;
				form1.role.value = response.role;
			})
			})
			}
		
		// 삭제버튼 : 그룹이벤트
		function userDelete() {
 			
			$("tbody").on("click",".btnDel",function(){
			const userid = $(this).closest("tr").children().first().html();
			console.log(userid)
			const url = "http://localhost/myserver/users/" + userid;
		 	$(this).closest("tr").remove();
			$.ajax({
				url : url,
				type : 'DELETE'
			}).done(function(response) {
			})
			}) 
		}
			

		// 전체조회 ajax 요청 
		function list() {
			const url = "http://localhost/myserver/users"; 
			$.ajax({
				url : url,
				type : 'GET'
			}).done(function(response) {
				for (user of response) {
					//console.log(user.id)
					$("tbody").append(makeTr(user));
				}
				
			})
		}

		function makeTr(user) {
			
 			var $tr = $("<tr>").data("id",user.id);
 			
			$("<td>").addClass("text-center").html(user.id).appendTo($tr);
			$("<td>").addClass("text-center").html(user.password).appendTo($tr);
			$("<td>").addClass("text-center").html(user.name).appendTo($tr);
			$("<td>").addClass("text-center").html(user.role).appendTo($tr);
			$("<td>").addClass("text-center").append($("<button>").addClass("btnUpd").html("조회"))
											 .append($("<button>").addClass("btnDel").html("삭제"))
											 .appendTo($tr); 
			
/* 			let tr = document.createElement("tr");
			tr.setAttribute("data-id", `${user.id}`);
			tr.innerHTML = `<td class="text-center">${user.id}</td>
					<td class="text-center">${user.password}</td>
					<td class="text-center">${user.name}</td>
					<td class="text-center">${user.role}</td>
					<td class="text-center">
						<button class="btnUpd">조회</button>
						<button class="btnDel">삭제</button>
					</td>`
					 */
			return $tr;
		}				
		$(function(){
			userInsert();
			userUpdate();
			userSelect();
			userDelete();
			list();
		})
		
	</script>
</body>

</html>