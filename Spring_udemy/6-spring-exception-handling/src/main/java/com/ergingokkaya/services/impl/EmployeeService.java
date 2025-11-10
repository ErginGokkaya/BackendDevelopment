package com.ergingokkaya.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ergingokkaya.DTOs.DtoDepartment;
import com.ergingokkaya.DTOs.DtoEmployee;
import com.ergingokkaya.entities.Department;
import com.ergingokkaya.entities.Employee;
import com.ergingokkaya.exception.BaseException;
import com.ergingokkaya.exception.ErrorMessage;
import com.ergingokkaya.exception.MessageType;
import com.ergingokkaya.repository.EmployeeRepository;
import com.ergingokkaya.services.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public DtoEmployee findEmployeeById(Long id) {
		Optional<Employee> dbEmployee =  employeeRepository.findById(id);
		if(dbEmployee.isEmpty())
		{			
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_FOUND, id.toString()));
		}
		
		Employee employee = dbEmployee.get();
		Department department = employee.getDepartment();
		
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDtoDepartment(dtoDepartment);
		
		return dtoEmployee;
		
	}

}
