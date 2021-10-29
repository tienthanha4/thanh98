package com.devpro.shop16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication


public class StartServer {
	public static void main(String[] args) {
//		System.out.println("start.....");
		System.out.println(new BCryptPasswordEncoder(4).encode("thanh98"));
		SpringApplication.run(StartServer.class,args);
		
		
		
	}

}