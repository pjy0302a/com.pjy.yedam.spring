package co.yedam.prj;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.prj.notice.vo.NoticeVO;

public class JacksonTest {

	static ObjectMapper om;
	
	@BeforeClass
	public static void init() {
		om = new ObjectMapper();
	}
	
	@Test
	public void readTreeTest2() throws MalformedURLException, IOException {
		String infoUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20212725"; //20212725
		JsonNode json = om.readTree(new URL(infoUrl));
		String str = json.get("movieInfoResult").get("movieInfo").get("directors").get(0).get("peopleNm").asText();
		System.out.println("감독 : " + str);
	}
	
	@Test
	public void readTreeTest() throws MalformedURLException, IOException {
		String boxUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220418"; 
		JsonNode json =  om.readTree(new URL(boxUrl));
	    String str = json.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		System.out.println(str);
	}
	
	@Test
	public void readTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"id\":0,\"title\":\"제목\",\"content\":\"내용\",\"wdate\":null,\"hit\":0}";
		
			NoticeVO vo = om.readValue(str,NoticeVO.class);
			assertEquals(vo.getTitle(), "제목");
			//System.out.println("vo : " + vo);

	}
	
	@Test
	public void writeTest() {
		NoticeVO vo = NoticeVO.builder()
				.title("제목")
				.content("내용")
				.build();
		String str;
		try {
			str = om.writeValueAsString(vo);
			System.out.println(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
