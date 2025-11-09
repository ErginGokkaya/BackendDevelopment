package com.ergingokkaya.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ergingokkaya.model.User;
import com.ergingokkaya.services.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService getUserService() {
		UserService userService = new UserService();
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("Ahmet"));
		userList.add(new User("Mehmet"));
		
		userService.setUserList(userList);
		
		return userService;
	}
}
