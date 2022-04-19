package co.yedam.prj;

import java.util.List;

import org.junit.Test;

import co.yedam.prj.bank.web.AccountVO;
import co.yedam.prj.bank.web.BankAPI;
import co.yedam.prj.bank.web.BankVO;

public class BankTest {
	   @Test
	   public void getBalance() {
	      BankVO vo = new BankVO();
	      long balance = BankAPI.getBalanceInfo(vo);
	      System.out.println(balance);
	   }
	   @Test
	   public void getAccountList() {
	      BankVO vo = new BankVO();
	      List<AccountVO> list = BankAPI.getAccountList(vo);
	      System.out.println(list.getClass());
	   }
	}
