package co.yedam.prj;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
		RestTemplate restTemplate = new RestTemplate();
		JsonNode json =  restTemplate.getForObject(infoUrl, JsonNode.class);
		json = json.get("movieInfoResult").get("movieInfo");
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		movieInfo mvInfo = om.treeToValue(json, movieInfo.class);
		
		System.out.println(mvInfo.getDirectors().get(0).get("peopleNm"));
//		System.out.println(mvInfo.getActors().get(0).get("peopleNm"));
//		String str = json.get("movieInfoResult").get("movieInfo").get("directors").get(0).get("peopleNm").asText();
//		System.out.println("감독 : " + str);
	}
	
	@Test
	public void readTreeTest() throws MalformedURLException, IOException {
		String boxUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220418"; 
		RestTemplate restTemplate = new RestTemplate();
		
		JsonNode json =  restTemplate.getForObject(boxUrl, JsonNode.class);
		JsonNode mvlist = json.get("boxOfficeResult").get("dailyBoxOfficeList");
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		MovieVO[] arr = om.treeToValue(mvlist, MovieVO[].class);
//		System.out.println(str);
	    List<MovieVO> list = Arrays.asList(arr);
	    System.out.println("영화제목 : " + list.get(0).getMovieNm());
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
