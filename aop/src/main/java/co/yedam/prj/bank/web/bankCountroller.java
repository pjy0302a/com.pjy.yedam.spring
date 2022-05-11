package co.yedam.prj.bank.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bankCountroller {
//	//콜백함수로 인증코드가 들어옴
//	@RequestMapping("/bankCallback")
//	public String bankCallback(String code) {
//		//code로 토큰 발급
//		TokenVO vo = BankAPI.getToken(code);
//		//
//		return "";
//	}
//	
//	//사용자 인증요청
//	@RequestMapping("/bankAuth")
//	public String bankAuth() throws Exception {
//		String redirect_uri= "http://localhost/prj/bankCallback";
//		String client_id = "fc4191dd-ecdd-44ba-ae12-2743ae515382";
//		
//		String reqUrl = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";
//		String url = reqUrl 
//				    +"?response_type=code"
//		            +"&client_id="+client_id
//				    +"&redirect_uri="+redirect_uri
//				    +"&scope=inquiry transfer login"
//				    +"&state=12345678901234567890123456789012"
//				    +"&auth_type=0";
//
//		return "redirect:"+ url;
//	}
	@GetMapping("/accountList")
	public List<AccountVO> accountList(BankVO vo){
		return BankAPI.getAccountList(vo);
	}
	@GetMapping("/balance")
	public long balance(BankVO vo) {
		return BankAPI.getBalanceInfo(vo);
	}
	
	@GetMapping("/transaction")
	public List<Map> transaction(BankVO vo) {
		return BankAPI.getTransaction(vo);
	}
	@PostMapping("/Update_info")
	public String Update_info(AccountVO vo) {
		return BankAPI.getUpdateInfo(vo);
	}
	@PostMapping("/real_name")
	public Map real_name(AccountVO vo) {
		return BankAPI.getRealName(vo);
	}
	
	
}
