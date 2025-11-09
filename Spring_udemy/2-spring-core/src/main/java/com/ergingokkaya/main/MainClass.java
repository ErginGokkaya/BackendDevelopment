package com.ergingokkaya.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ergingokkaya.config.AppConfig;
import com.ergingokkaya.model.User;
import com.ergingokkaya.services.LoginService;
import com.ergingokkaya.services.UserService;

//import java.util.ArrayList;
//import java.util.List;
//
//import com.ergingokkaya.model.User;
//import com.ergingokkaya.services.UserService;

public class MainClass {

	public static void main(String[] args) {
//		UserService userService1 = new UserService();
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(new User("Ali"));
//		userList.add(new User("Veli"));
//		
//		userService1.setUserList(userList);
//		
//		UserService userService2 = new UserService();
		
		// @Configuration ile isaretlenen sinifin adi ile bir spring context olusturulur ve o sinifin bean'leri context'e dondurulur.
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService =  context.getBean(UserService.class);

		for (User user : userService.getUserList()) {
			 System.out.println(user.getFirstName());
		}
		
		LoginService loginService = new LoginService();
		loginService.login();
	}

}
