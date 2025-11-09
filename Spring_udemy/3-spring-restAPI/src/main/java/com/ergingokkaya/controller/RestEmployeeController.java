package com.ergingokkaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ergingokkaya.model.Employee;
import com.ergingokkaya.service.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/list")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id)
	{
		System.out.println(id);
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/list-params")
	public List<Employee> getEmployeesWithParams(@RequestParam(name = "firstName") String firstName, 
			                                     @RequestParam(name = "lastName") String lastName)
	{
		return employeeService.getEmployeesWithParams(firstName, lastName);
	}
	
	@PostMapping(path = "/save-employee")
	public boolean addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);		
	}
	
	
	@DeleteMapping(path = "/delete-employee/{id}")
	public Employee deletEmployeebyId(@PathVariable(name = "id") String id)
	{
		return employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping(path = "/update-employee/{id}")
	public Employee updateEmployeeById(@PathVariable(name = "id") String id, @RequestBody Employee employee)
	{
		return employeeService.updateEmployeeById(employee.getId(),employee.getFirstName(),employee.getLastName());
	}
}
