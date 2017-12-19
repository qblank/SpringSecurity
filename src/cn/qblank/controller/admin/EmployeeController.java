package cn.qblank.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.qblank.entity.Employee;
import cn.qblank.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/admin/employees")
	public String getAll(Model model){
		//获取数据
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "admin/employees";
	}
}
