package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.bo.Employee;
import com.nt.bo.EmployeeDTO;
import com.nt.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		Employee employee = new Employee();
		model.addAttribute(employee);
		return "employees";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String SaveEmployee(@ModelAttribute Employee employee) {
		service.save(employee);
		return "redirect:/employeesDetails";
	}

	@RequestMapping(value = "/employeesDetails", method = RequestMethod.GET)
	public String getEmployee(Model model) {
		// List<EmployeeDTO> alldetails = service.getEmployee();
		List<Employee> alldetails = service.getEmployee();
		System.out.println(alldetails);
		model.addAttribute("employeeList", alldetails);
		return "employeesDetails";
	}

	@RequestMapping(value = "employeesDetails/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable int id, Model model) {
		EmployeeDTO dto = service.employeeFindById(id);
		model.addAttribute("findList", dto);
		return "employeesDetails";
	}

	@RequestMapping(value = "searchDetails", method = RequestMethod.GET)
	public String search(@RequestParam String proname, Model model) {
		EmployeeDTO dto = service.empSearch(proname);
		model.addAttribute("searchList", dto);
		return "searchpage";

	}
}// class
