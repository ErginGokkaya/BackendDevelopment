package com.ergingokkaya.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ergingokkaya.model.Employee;


@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployees()
	{
		return employeeList;
	}
	
	public Employee getEmployeeById(String id)
	{
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId()))
			{
				return employee;
			}
		}
		return null;
	}
	
	public List<Employee> getEmployeesWithParams(String firstName, String lastName)
	{
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : employeeList) {
			if(employee.getFirstName().equals(firstName) &&
					employee.getLastName().equals(lastName))
				employees.add(employee);
		}
		
		return employees;
	}
	
	public boolean addEmployee(Employee employee)
	{
		boolean isAnEmployee = false;
		
		if(!employee.getId().isEmpty() && !employee.getFirstName().isEmpty() && !employee.getLastName().isEmpty())
		{
			isAnEmployee = true;
			employeeList.add(employee);
		}
		return isAnEmployee;
	}
	
	public Employee deleteEmployeeById(String id)
	{
		for (Employee employee : employeeList) {
			if (employee.getId().equals(id)) {
				Employee temp = employee;
				employeeList.remove(employee);
				return temp;
			}
		}
		
		return null;
	}
	
	public Employee updateEmployeeById(String id, String firstName, String lastName)
	{
		for (Employee employee : employeeList) {
			if(employee.getId().equals(id))
			{
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				return employee;
			}
		}
		
		return null;
	}
}
