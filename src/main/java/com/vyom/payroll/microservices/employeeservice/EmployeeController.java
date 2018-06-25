package com.vyom.payroll.microservices.employeeservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	Environment env;
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeDetails(@PathVariable Long empId) {
		//return new Employee("Vyom","Rastogi",257801L,new Date());
		
		Employee employee = employeeRepository.findOne(empId);
		employee.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return employee;
	}

}