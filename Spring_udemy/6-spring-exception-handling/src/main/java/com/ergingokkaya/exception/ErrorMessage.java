package com.ergingokkaya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	private MessageType messageType;
	private String manual;
	public String prepareErrorMessage()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(messageType.getMessage());
		
		if(!manual.isEmpty())
		{
			sb.append(": " + manual);
		}
		
		return sb.toString();
	}
}
