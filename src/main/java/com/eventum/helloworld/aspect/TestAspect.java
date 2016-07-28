package com.eventum.helloworld.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	@Before("com.eventum.helloworld.aspect.SystemArchitecture.inServiceLayer()")
	public void testBefore(){
		System.out.println("Before.");
	}
	
	
}
