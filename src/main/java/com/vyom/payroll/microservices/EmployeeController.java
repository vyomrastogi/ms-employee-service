package com.vyom.payroll.microservices;

import java.util.Optional;

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
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		Employee employee = new Employee();
		if(optionalEmployee.isPresent()) {
			optionalEmployee.get().setPort(Integer.parseInt(env.getProperty("local.server.port")));
			employee = optionalEmployee.get();
		}		
		return employee;
	}

}