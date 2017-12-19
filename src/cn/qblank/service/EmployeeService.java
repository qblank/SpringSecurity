package cn.qblank.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import cn.qblank.entity.Employee;

public interface EmployeeService {
//	@Secured("ROLE_HR")
	//添加访问权限为全部登录以及是HR用户
	@PreAuthorize("isFullyAuthenticated() && hasRole('HR')")
	List<Employee> findAll();
}
