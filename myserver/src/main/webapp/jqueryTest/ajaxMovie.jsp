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
<script>
	const url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220412"
		$.ajax(url)
		.done(function(data) {
//			console.log(typeof data);
//			console.log(data);
			for(d of data.boxOfficeResult.dailyBoxOfficeList){
				console.log(d.movieNm + " " +d.movieCd );
						}
		})
	const url2 = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20204431"
		//영화감독출력
		$.ajax(url2)
		.done(function(data){
			console.log(data);
			console.log(data.movieInfoResult.movieInfo.directors[0].peopleNm);
		})
</script>
</body>
</html>