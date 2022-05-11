package co.yedam.prj.bank.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BankAPI {
	static String use_org_code = "M202200499";
	
	static String oob_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMjAwNDk5Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjU4MTkwMDgxLCJqdGkiOiIwNzBiYmRkNC0wYjk5LTRkODktOTg1MS0zMzcxY2I2MmYwMDcifQ.iWQc-lxO9PK965jKaSfH3qSk4MWGt1tL6fw1QJtUxKQ";
	static String client_id = "fc4191dd-ecdd-44ba-ae12-2743ae515382";
	static String client_secret = "892130eb-1af7-43ad-be07-f3d2e8b15481";
	static String redirect_uri = "http://localhost:800/html/callback.html";
	static String grant_type = "authorization_code";
	static String accessToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDA1ODYxIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTgxMTU0NTIsImp0aSI6IjVjNzQ4MjExLWFlMmEtNDk5ZS1hMmU3LWM0YzA1MTczOWU0MCJ9.0EG_3bFIpdmjgqgC7LY2k1IQRiq0AvMY-vnBrQnT4eU";
	public static String getSequence() {
		long t = System.nanoTime();
		String result = String.valueOf(t);
		result = result.substring(result.length() - 9);
		return result;

	}

	public static String getDate() {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		result = sdf.format(date);
		return result;
	}

	public static long getBalanceInfo(BankVO vo) {
		long balance = 0;
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";
		String param = "bank_tran_id=" + use_org_code + "U" + getSequence(); // System.currentTimeMillis()
		param += "&tran_dtime=" + getDate(); // getData();
		param += "&fintech_use_num=" + vo.getFintechUseNum();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer" + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		Map json = response.getBody();
		balance = Long.valueOf((String) json.get("balance_amt"));
		return balance;
	}
	
	public static TokenVO getToken(String authCode) {
		String reqURL = "https://testapi.openbanking.or.kr/oauth/2.0/token";
		//파라미터 setting
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>() ;
		map.add("access_token", authCode);
		map.add("client_id", client_id);
		map.add("client_secret", client_secret);
		map.add("redirect_uri", redirect_uri);
		map.add("grant_type", grant_type);


		
		//header setting
		HttpHeaders headers = new HttpHeaders();
		headers.set("header", "status: 200");
		headers.set("content-type", "application/json; charset=UTF-8");
		//request 생성 
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String,String>>(map, headers);
		//RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL, HttpMethod.POST, request,
				Map.class);
		List<Map> arr = (List) response.getBody().get("res_list");
		System.out.println(arr.getClass());
		System.out.println(arr);
		return null;
	}
	public static List<AccountVO> getAccountList(BankVO vo) {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";
		String param = "user_seq_no=" + vo.getUserSeqNo(); // System.currentTimeMillis()
		param += "&include_cancel_yn=Y"; // getData();
		param += "&sort_order=D";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer" + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AccountList> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request,
				AccountList.class);
		System.out.println(response.getBody().getRes_list());
		return response.getBody().getRes_list();
	}
	
	public static List<Map> getTransaction(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num";
		String param = vo.getFintechUseNum();
		//파라미터 setting
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>() ;
		map.add("bank_tran_id", use_org_code + "U" + getSequence());
		map.add("fintech_use_num", param);
		map.add("inquiry_type", "A");
		map.add("inquiry_base", "D");
		map.add("from_date", "20190101");
		map.add("from_time", "010101");
		map.add("to_date", "20190101");
		map.add("to_time", "010101");
		map.add("sort_order", "A");
		map.add("tran_dtime", "20220420110919");

		//MultiValueMap => queryString 으로 변환
		String uri = UriComponentsBuilder.fromUriString(reqURL).queryParams(map).toUriString();
		
		//header setting
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer" + vo.getAccessToken());
		//request 생성 
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String,String>>(map, headers);
		//RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				Map.class);
		List<Map> arr = (List) response.getBody().get("res_list");
		System.out.println(arr.getClass());
		System.out.println(arr);
		return arr;
	}
	
	public static Map getRealName(AccountVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/inquiry/real_name";
		Map<String, String> param = new HashMap<>();
		param.put("bank_tran_id", use_org_code + "U" + getSequence());
		param.put("bank_code_std", "097");
		param.put("account_num", vo.getAccount_num());
		param.put("account_holder_info_type", " ");
		param.put("account_holder_info", vo.getAccount_holder_info());
		param.put("tran_dtime", getDate());
		String jsonValue="";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonValue = objectMapper.writeValueAsString(param);
			//System.out.println(jsonValue);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/json; charset=UTF-8");
		headers.set("Authorization", "Bearer " + oob_token);

		HttpEntity<String> request = new HttpEntity<String>(jsonValue,headers);

		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.postForObject(reqURL, request, Map.class);

		//String realName = response.get("account_holder_name").toString();//이름출력
		System.out.println(response);
		return response;
	}
	public static String getUpdateInfo(AccountVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/update_info";
		Map<String, String> param = new HashMap<>();
		param.put("fintech_use_num", vo.getFintech_use_num());
		param.put("account_alias", vo.getAccount_alias());
		System.out.println(vo.getFintech_use_num() + vo.getAccount_alias());
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/json; charset=UTF-8");
		headers.set("Authorization", "Bearer" + accessToken);

		HttpEntity<Map> request = new HttpEntity<Map>(param,headers);

		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.postForObject(reqURL, request, Map.class);
		System.out.println(response);
		String realName = (String) response.get("account_alias");//이름출력
		System.out.println(realName);
		return realName;
		
	}

}