package cn.qblank.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.qblank.entity.Employee;
import cn.qblank.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService	{
	@Override
	public List<Employee> findAll() {
		//ʹ�ü���ģ�⼯��
		return Arrays.asList(
				new Employee(1, "����", "��"),
				new Employee(2,"����","Ů"),
				new Employee(3,"����","��"));
	}

}
