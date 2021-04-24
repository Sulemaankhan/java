package com.nt.dao;

import java.util.List;

import com.nt.bo.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);

	public List<Employee> findAll();

	public Employee findById(int id);

	

	Employee searcEmployee(String name);

}
