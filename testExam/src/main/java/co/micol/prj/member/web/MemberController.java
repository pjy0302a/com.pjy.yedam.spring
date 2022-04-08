package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;

	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		model.addAttribute("members", memberDao.memberSelectList());
		return "member/memberSelectList";
	}
	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo,Model model) {
		model.addAttribute("members", memberDao.memberSelect(vo));
		return "member/memberSelect";
	}
	@RequestMapping("/memberInsertForm.do")
	public String memberInsertForm(Model model) {
		return "member/memberInsertForm";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsertForm(MemberVO vo,Model model) {
		memberDao.memberInsert(vo);
		return "redirect:memberSelectList.do";
	}
}
