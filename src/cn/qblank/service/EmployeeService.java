package cn.qblank.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import cn.qblank.entity.Employee;

public interface EmployeeService {
//	@Secured("ROLE_HR")
	//��ӷ���Ȩ��Ϊȫ����¼�Լ���HR�û�
	@PreAuthorize("isFullyAuthenticated() && hasRole('HR')")
	List<Employee> findAll();
}
