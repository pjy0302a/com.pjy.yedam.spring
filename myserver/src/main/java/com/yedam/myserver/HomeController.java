package com.yedam.myserver;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.myserver.users.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("list")
	public void list(Model model) {	
		model.addAttribute("users", Arrays.asList("choi", "park"));
	}
	
	@GetMapping("insert")
	public String insert(@ModelAttribute("user") UserVO vo
						 , Model model) {
		model.addAttribute("profile", vo);
		return "insert";
	}
	@PostMapping("insert")
	public String insertProc(RedirectAttributes ra) {
		ra.addAttribute("page", 2);
		ra.addAttribute("keyword", "park");
		ra.addFlashAttribute("msg", "등록완료");	//한번, 새로고침 삭제
		return "redirect:list";	//list?page=2&keyword=park
	}
}
