package co.yedam.prj.bank.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class BankAPI {
    public static String getSequence() {
    	long t = System.nanoTime();
    	String result = String.valueOf(t);
    	result = result.substring(result.length()-9);
    	return result;
   	 
    }
    public static String getDate() {
    	String result = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    	Date date = new Date();
    	result = sdf.format(date);
    	return result;
    }
	
   public static long getBalanceInfo(BankVO vo){
      long balance = 0;
      //System.out.println("fin num:" + vo.getFintechUseNum());
      String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";
      String param = "bank_tran_id=M202200499" + "U" + getSequence();	//System.currentTimeMillis()
      param +="&tran_dtime=" + getDate();		//getData();
      param +="&fintech_use_num=" + vo.getFintechUseNum();
      
      HttpHeaders headers = new HttpHeaders();
      headers.set("Authorization", "Bearer" + vo.getAccessToken());
      
      
        HttpEntity<MultiValueMap<String, String>> request = 
              new HttpEntity<MultiValueMap<String, String>>(null, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(   reqURL + "?" + param,
                                               HttpMethod.GET,
                                              request,
                                              Map.class );
      
        Map json = response.getBody();
        balance = Long.valueOf((String) json.get("balance_amt")) ;
      return balance;
   }
   
   public static List<AccountVO> getAccountList(BankVO vo){

	      
	      String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";
	      String param = "user_seq_no=" + vo.getUserSeqNo();	//System.currentTimeMillis()
	      param +="&include_cancel_yn=Y";		//getData();
	      param +="&sort_order=D";
	      
	      HttpHeaders headers = new HttpHeaders();
	      headers.set("Authorization", "Bearer" + vo.getAccessToken());
	      
	      
	        HttpEntity<MultiValueMap<String, String>> request = 
	              new HttpEntity<MultiValueMap<String, String>>(null, headers);
	        
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<AccountList> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, AccountList.class );
//	        System.out.println(response.getBody());
	        
			/*
			 * ObjectMapper om = new ObjectMapper(); try { JsonNode json =
			 * om.readTree(response.getBody()); System.out.println(json.asText()); } catch
			 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 */
	        
	        //ObjectMapper
	        //str -> jsonNode(readtree)
	        //res_list 필드 -> jsonString -> AccountVO[] -> List<VO>
	      return response.getBody().getRes_list();
	   }
}