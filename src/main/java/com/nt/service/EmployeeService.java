package com.nt.service;

import java.util.List;

import com.nt.bo.Employee;
import com.nt.bo.EmployeeDTO;

public interface EmployeeService {
	public void save(Employee employee);

	public List<Employee> getEmployee();

	public EmployeeDTO employeeFindById(int id);

	public EmployeeDTO empSearch(String name);

}
