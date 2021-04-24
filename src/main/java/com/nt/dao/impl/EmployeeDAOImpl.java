package com.nt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.Employee;
import com.nt.bo.EmployeeDTO;
import com.nt.dao.EmployeeDAO;

@Repository("userDao")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String employeereg = "insert into employee (ename, proname, emailid) values (?,?,?)";
	private static final String findEmployee = "select id,ename,proname,emailid from employee";
	private static final String Get_DetailsById = "select ename,proname,emailid from employee where id=?";
	private static final String GET_EMPs_BY_SEARCH_DETAILS =
			"select ename,proname,emailid FROM employee WHERE proname=?";
	@Autowired
	private JdbcTemplate jt;

	public void save(Employee employee) {

		jt.update(employeereg, new Object[] { employee.getEname(), employee.getProjactname(), employee.getEmail() });

	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = jt.query(findEmployee, new EmployeeRowMapper());
		return list;
	}

	@Override
	public Employee findById(int id) {

		Employee bo = jt.queryForObject(Get_DetailsById, new EmployeeRowMapper(), id);
		return bo;

	}

	@Override
	public Employee searcEmployee(String name) {

		Employee bo = jt.queryForObject(GET_EMPs_BY_SEARCH_DETAILS, new EmployeeRowMapper(), name);
		return bo;

	}
}
