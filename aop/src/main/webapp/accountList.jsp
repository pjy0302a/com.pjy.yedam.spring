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
<div id = "list"></div>
	<script>
		$.ajax("/prj/accountList")
		.done(function(response) {
			for (account of response) {
				const div = $("<div>");
				$("<span>").html(account.fintech_use_num).appendTo(div);
				$("<span>").html(" 계좌닉 : " +account.account_alias).appendTo(div);
				$("<span>").html(" 은행명 : " +account.bank_name).appendTo(div);
				$("<button>").text("클릭").appendTo(div);
				$("#list").append(div)
			}
		})
		
		$("#list").on("click","button", function() {
			const fintechUseNum = $(this).parent().children().eq(0).html();
			$.ajax("/prj/balance?fintechUseNum="+fintechUseNum)
			.done(function(response) {
				alert(response);
			})
		})
	</script>
</body>
</html>