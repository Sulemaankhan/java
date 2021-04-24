package com.nt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.Employee;
import com.nt.bo.EmployeeDTO;
import com.nt.dao.EmployeeDAO;
import com.nt.service.EmployeeService;

@Service("userService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO empDao;

	public void save(Employee employee) {
		empDao.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
//		List<EmployeeDTO> listDTO = null;
//		List<Employee> listBO = empDao.findAll();
//		System.out.println("Servive  :"+listBO);
//		// copy listBo to listDto
//		listDTO = new ArrayList<EmployeeDTO>();
//		if (listBO != null)
//			for (Employee bo : listBO) {
//				EmployeeDTO dto = new EmployeeDTO();
//				dto.setEname(bo.getEname());
//				dto.setProjactname(bo.getProjactname());
//				dto.setEmail(bo.getEmail());
//				listDTO.add(dto);
//			} // for
//		return listDTO;

//	}

		List<Employee> list = empDao.findAll();
		System.out.println("service : " + list);
		if (list != null) {
			return list;
		} else {
			System.out.println("Service :null" + list);
		}
		return list;
	}

	@Override
	public EmployeeDTO employeeFindById(int id) {

		// use dao
		Employee bo = empDao.findById(id);
		// convert bo to dto
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(bo.getEname());
		dto.setEmail(bo.getEmail());
		dto.setProjactname(bo.getProjactname());
		return dto;
	}

	@Override
	public EmployeeDTO empSearch(String name) {
		// use dao
		Employee bo = empDao.searcEmployee(name);
		// convert bo to dto
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(bo.getEname());
		dto.setEmail(bo.getEmail());
		dto.setProjactname(bo.getProjactname());
		return dto;
	}
}
