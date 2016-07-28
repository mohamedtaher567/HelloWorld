package com.eventum.helloworld.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemArchitecture {

	@Pointcut("args(*,int,..)")
	public void inServiceLayer(){		
	}
}
