package co.yedam.prj.bank.web;

import lombok.Data;

@Data
public class AccountVO {
	   private String fintech_use_num;
	   private String account_alias;
	   private String bank_name;
	   private String account_num_masked;
	   private String account_holder_info;
	   private String account_num;
}
