package com.eventum.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	String message = "Welcome to Spring MVC!";
	public String getMessage(String x, int s,int ss, int as)
	{
		System.out.println(message);
		return message;
	}
}
