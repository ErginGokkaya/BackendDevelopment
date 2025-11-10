package com.ergingokkaya.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ergingokkaya.DTOs.DtoEmployee;
import com.ergingokkaya.controller.IEmployeeController;
import com.ergingokkaya.services.IEmployeeService;

@RestController
@RequestMapping(path = "/rest/api/employee")
public class EmployeeController implements IEmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoEmployee findEmployeeById(@PathVariable(value = "id") Long id)
	{
		return employeeService.findEmployeeById(id);
	}

}
