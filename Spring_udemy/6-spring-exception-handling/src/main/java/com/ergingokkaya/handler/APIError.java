package com.ergingokkaya.handler;

import lombok.Data;

@Data
public class APIError<E> {
	
	private Integer status;
	private Exception<E> exception;

}
