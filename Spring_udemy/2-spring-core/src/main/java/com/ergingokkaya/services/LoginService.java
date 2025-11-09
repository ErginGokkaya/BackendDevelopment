package com.ergingokkaya.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ergingokkaya.config.AppConfig;

public class LoginService {
	public void login() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService =  context.getBean(UserService.class);
	}
}
