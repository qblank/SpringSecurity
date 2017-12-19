package cn.qblank.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET,value = "/")
	public String index(@AuthenticationPrincipal User user,Model model){
		model.addAttribute("user", user);
		return "index";
	}
}
