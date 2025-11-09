package com.ergingokkaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ergingokkaya.model.Employee;
import com.ergingokkaya.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees()
	{		
		return employeeRepository.getAllEmployees();
	}
	
	public Employee getEmployeeById(String id)
	{
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeesWithParams(String firstName, String lastName)
	{
		return employeeRepository.getEmployeesWithParams(firstName,lastName);
	}
	
	public boolean addEmployee(Employee employee)
	{
		return employeeRepository.addEmployee(employee);
	}
	
	public Employee deleteEmployeeById(String id)
	{
		return employeeRepository.deleteEmployeeById(id);
	}
	
	public Employee updateEmployeeById(String id, String firstName, String lastName)
	{
		return employeeRepository.updateEmployeeById(id,firstName,lastName);
	}
}
