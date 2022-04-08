package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {	
		return "home/home";
	}

	@RequestMapping("/home.do")
	public String home() {	
		return "home/home";
	}	
}
