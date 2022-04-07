package co.micol.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home/home";
	}
	@RequestMapping("/home.do")
	public String home() {
		return "home/home";
	}
	@RequestMapping("/home.do")
	public ModelAndView home(ModelAndView mv) {
		int a = 0;
		mv.addObject("message","나의 페이지에 온것을 환영한다.");
		if(a == 1)
			mv.setViewName("home/home");
		else
			mv.setViewName("home/home2");
		return mv;
	}
	@RequestMapping("/home.do")
	public String home(Model model) {
		int a = 0;
		String str;
		model.addAttribute("message","나의 페이지에 온것을 환영한다.");
		if(a == 1)
			str = ("home/home");
		else
			str = ("home/home2");
		return str;
	}
}
