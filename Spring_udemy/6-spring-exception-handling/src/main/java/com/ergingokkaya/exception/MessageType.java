package com.ergingokkaya.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_FOUND("1001","Record does not exit for id"),
	GENERAL_EXCEPTION("9999","Something unexpected happened");
	
	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private String code;
	private String message;
}
