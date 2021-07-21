package com.a0521.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a0521.pma.dao.EmployeeRepository;
import com.a0521.pma.entity.Employee;
import com.a0521.pma.entity.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createProject(Employee employee, Model model) {
		//this should handle saving to the database
		empRepo.save(employee);
		
		return "redirect:/";
	}

}
