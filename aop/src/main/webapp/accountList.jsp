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
<div id = "list">
	<div class="acc" data-usernum="12323232"><span>대구은행</span><span>1111222***</span></div>
</div>
<div id ="result">
</div>
	<script>
		$.ajax("/prj/accountList")
		.done(function(response) {
			for (account of response) {
				$("<div>").addClass("acc")
				          .data("usenum",account.fintech_use_num)
				.append($("<span>").html(account.fintech_use_num))
				.append($("<span>").html(" 계좌닉 : " +account.account_alias))
				.append($("<span>").html(" 은행명 : " +account.bank_name))
				.append($("<button>").html("잔액조회").addClass("btnMoney"))
				.append($("<span>").html(""))
				.append($("<button>").html("거래내역").addClass("btnTrans"))
				.appendTo($("#list"));
			}
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