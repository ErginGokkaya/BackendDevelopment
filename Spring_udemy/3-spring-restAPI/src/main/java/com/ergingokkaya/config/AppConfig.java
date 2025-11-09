package com.ergingokkaya.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ergingokkaya.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList()
	{
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("1", "Ahmet", "Yilmaz"));
		employees.add(new Employee("2", "Mehmet", "Yildiz"));
		employees.add(new Employee("3", "Ali", "Veli"));
		employees.add(new Employee("4", "Ahmet", "Yilmaz"));
		
		return employees;
		
	}
}
