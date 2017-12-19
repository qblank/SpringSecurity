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
		//使用集合模拟集合
		return Arrays.asList(
				new Employee(1, "张三", "男"),
				new Employee(2,"李四","女"),
				new Employee(3,"王五","男"));
	}

}
