<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	.active {background-color: green; color : white}
</style>
</head>
<body>
	<input id = "book">
	<ul>
		<li data-isbn="102" data-price="1000"><span>스프링</span></li>
		<li data-isbn="103"><span>자바</span></li>
		<li data-isbn="104"><span>리액트</span></li>
	</ul>
	<script>
		$("#book").on("keypress",function(){
			if(event.keyCode == 13){ //엔터키
				//$("ul").append($"<li>").html( $("#book").val());
				//$("<li>").html($("#book").val()).appendTo($("ul"))
				$("<li>").append($("<span>").html($("#book").val()))
				.data("isbn",101)
				.appendTo($("ul"))
				
				$("#book").val("")
			}
		});
/* 		$("li").on("mouseover", function(){
			//배경색 변경 : css()
			//$(event.target) //$(this)
			$(this).addClass("active");
		})
		$("li").on("mouseout", function(){
			//배경색 변경 : css()
			//$(event.target) //$(this)
			$(this).removeClass("active");
		}) */
		//그룹이벤트(부모에 위임)
		$("ul").on("mouseover mouseout", "span",function(){
			$(this).toggleClass("active");
			//span 부모 li태그의 isbn 데이터 속성 출력
			console.log($(this).parent().data("isbn"));
		})
	</script>
</body>
</html>