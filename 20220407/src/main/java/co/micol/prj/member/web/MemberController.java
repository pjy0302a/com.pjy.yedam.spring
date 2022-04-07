package co.micol.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/memberLoginForm.do")
	public String MemberLoginForm(Model model) {
		return "memberLoginForm";
	}
}
