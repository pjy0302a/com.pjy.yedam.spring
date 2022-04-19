package co.yedam.prj.bank.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bankCountroller {

	@GetMapping("/accountList")
	public List<AccountVO> accountList(BankVO vo){
		return BankAPI.getAccountList(vo);
	}
	@GetMapping("/balance")
	public long balance(BankVO vo) {
		return BankAPI.getBalanceInfo(vo);
	}
}
