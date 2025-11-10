package com.ergingokkaya.controller;

import com.ergingokkaya.DTOs.DtoEmployee;

public interface IEmployeeController {

	public DtoEmployee findEmployeeById(Long id);
}
