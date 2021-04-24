package com.nt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getLong("id"));
		employee.setEname(rs.getString("ename"));
		employee.setProjactname(rs.getString("proname"));
		employee.setEmail(rs.getString("emailid"));
		return employee;
	}

}
