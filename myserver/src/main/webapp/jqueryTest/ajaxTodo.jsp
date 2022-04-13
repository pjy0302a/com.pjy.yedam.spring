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
<h3>todo list</h3>
<input id="title"><button id="btn">등록</button>
<div id="list">
	<div data-id="1">title completed</div>
</div>
<script>
	const url = "https://jsonplaceholder.typicode.com/todos"

	$("#btn").on("click" , function(){
		$.ajax({
			url : url,
			method :'POST',
			data : JSON.stringify({title : $("#title").val(), userId : "kim", completed: false}),
			contentType : "application/json"
		}).done(function(response){
			console.log(response)
		});
	})
	
	
	$.ajax(url)
	.done(function(data){
		for(todo of data){
			//div 태그 생성해서 추가
			//completed가 true 이면 color red
			let div = $("<div>")
			div.html(todo.title + todo.completed)
			.data("id",todo.id)
			.appendTo($("#list"));
			if(todo.completed){
				div.css("color","red");
			}
			}
		})
</script>
</body>
</html>