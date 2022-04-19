package co.yedam.prj.movie.web;

import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieApi {
	static ObjectMapper om = new ObjectMapper();

//1위영화
	public static String firstMovie(String targetDt) {
		String name = "";
		String boxUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt="
				+ targetDt;

		try {
			JsonNode json = om.readTree(new URL(boxUrl));
			JsonNode str = json.get("boxOfficeResult").get("dailyBoxOfficeList").get(0);
			// .get("movieNm").asText();

			name = str.get("movieNm").asText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;

	}
//영화감독

//영화리스트
}
