package com.ergingokkaya.services;

import com.ergingokkaya.DTOs.DtoEmployee;

public interface IEmployeeService {
	
	public DtoEmployee findEmployeeById(Long id);
}
