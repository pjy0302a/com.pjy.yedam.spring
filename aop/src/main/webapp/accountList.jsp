<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<title>Insert title here</title>
</head>
<body>
	<h3>계좌리스트</h3>
	<div id="list">
		<div class="acc" data-usernum="12323232">
			<span>계좌번호</span><input type="text" id="num1"/><span>주민번호앞자리</span><input type="text" id="num2"/>
			<button class="btnReal">실명인증하기</button>
		</div>
		<span>결과 : </span><div id="name"></div>
	</div>
	<div id="result"></div>
	<script>
		$.ajax("/prj/accountList")
		.done(function(response) {
			for (account of response) {
				$("<div>").addClass("acc")
				          .data("usenum",account.fintech_use_num)
				.append($("<span>").html(account.fintech_use_num))
				.append($("<span>").html(" 계좌별칭 : "))
				.append($("<input type=text>").val(account.account_alias))
				.append($("<button>").html("변경").addClass("btnAlias"))
				.append($("<span>").html(" 은행명 : " +account.bank_name))
				.append($("<span>").html(" 계좌번호 : " +account.account_num_masked))
				.append($("<button>").html("잔액조회").addClass("btnMoney"))
				.append($("<span>").html(""))
				.append($("<button>").html("거래내역").addClass("btnTrans"))
				.appendTo($("#list"));
			}
		})
		
		//실명조회
		$("#list").on("click",".btnReal", function() {

			//console.log($(this).next());
			var num = $("#num1").val();
			var as = $("#num2").val();


			 $.ajax({
				url:"/prj/real_name",
				method : "POST",
				data : {
						account_num : num,
						account_holder_info : as
						}
				
			})
			.done(function(data) {
				$("#name").html(data.account_holder_name);
			}) 
		})
		//별명변경
		$("#list").on("click",".btnAlias", function() {

			console.log($(this).next());
			var num = $(this).parent().children().eq(0).html();
			var as = $(this).parent().find('input').val();
			//console.log(num1);
			//const btn = $(this);
			 $.ajax({
				url:"/prj/Update_info",
				method : "POST",
				data : {
						fintech_use_num : num,
						account_alias : as
						}
				
			})
			.done(function(data) {
			}) 
		})
		//잔액조회
		$("#list").on("click",".btnMoney", function() {

			console.log($(this).next());
			var num = $(this).parent().children().eq(0).html();
			
			const btn = $(this);
			$.ajax({
				url:"/prj/balance",
				data : {fintechUseNum : num}
			})
			.done(function(data) {
				btn.next().remove()
				$("<span>").html(data).insertAfter(btn);
				
				
			})
		})
		//거래내역조회
		$("#list").on("click",".btnTrans", function(){
			$("#result").empty()
			var num = $(this).parent().children().eq(0).html();
			
			$.ajax({
				url:"/prj/transaction",
				data : {fintechUseNum : num},
				method : "POST"
			})
			.done(function(data) {
				
				for (account of data) {
					
					$("<div>")
					.append( $("<span>").html(account.tran_date))
					.append( $("<span>").html(account.tran_time))
					.append( $("<span>").html(account.inout_type))
					.append( $("<span>").html(account.tran_type))
					.append( $("<span>").html(account.print_content))
					.append( $("<span>").html(account.tran_amt))
					.append( $("<span>").html(account.after_balance_amt))
					.append( $("<span>").html(account.branch_name))
					.appendTo($("#result"));
					
				} 
			})
		})
	</script>
</body>
</html>