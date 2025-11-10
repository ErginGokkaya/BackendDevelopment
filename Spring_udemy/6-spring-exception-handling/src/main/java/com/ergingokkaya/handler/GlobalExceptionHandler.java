package com.ergingokkaya.handler;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ergingokkaya.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<APIError> handleBaseException(BaseException exception, WebRequest webRequest)
	{
		return ResponseEntity.badRequest().body(creatApiError(exception.getMessage(), webRequest));
		// return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	private String getHostName()
	{
		try {
			return InetAddress.getLocalHost().getHostName(); 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public <E> APIError<E> creatApiError( E message, WebRequest webRequest)
	{
		Exception<E> exception = new Exception<>();
		exception.setHostName(getHostName());
		exception.setPath(webRequest.getDescription(false).substring(4));
		exception.setMessage(message);
		exception.setCreateTime(new Date());
		
		APIError<E> apiError = new APIError<>();
		
		apiError.setException(exception);
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return apiError;
	}
}
