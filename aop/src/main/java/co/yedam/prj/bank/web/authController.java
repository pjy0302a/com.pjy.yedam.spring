package co.yedam.prj.bank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class authController {
	//콜백함수로 인증코드가 들어옴
		@RequestMapping("/bankCallback")
		public String bankCallback(String code) {
			//code로 토큰 발급
			TokenVO vo = BankAPI.getToken(code);
			//
			return "";
		}
		
		//사용자 인증요청
		@RequestMapping("/bankAuth")
		public String bankAuth() throws Exception {
			String redirect_uri= "http://localhost/prj/bankCallback";
			String client_id = "fc4191dd-ecdd-44ba-ae12-2743ae515382";
			
			String reqUrl = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";
			String url = reqUrl 
					    +"?response_type=code"
			            +"&client_id="+client_id
					    +"&redirect_uri="+redirect_uri
					    +"&scope=inquiry transfer login"
					    +"&state=12345678901234567890123456789012"
					    +"&auth_type=0";

			return "redirect:"+ url;
		}
}
