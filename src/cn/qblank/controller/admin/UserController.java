package cn.qblank.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@RequestMapping(method = RequestMethod.GET,value = "/admin/users")
	public String showAll(){
		return "admin/users";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/login")
	public String show(
			@RequestParam(required = false) String error ,
			@RequestParam(required = false) String logout){
		if (error != null) {
			System.out.println("������תҳ��");
		}
		
		if (logout != null) {
			System.out.println("�˳�ϵͳ������");
		}
		
		return "login";
	}
}
