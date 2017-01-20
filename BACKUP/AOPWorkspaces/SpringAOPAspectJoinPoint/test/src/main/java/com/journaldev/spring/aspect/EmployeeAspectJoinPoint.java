package com.journaldev.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

@Aspect
public class EmployeeAspectJoinPoint {
	
	@After("execution(public void com.journaldev.spring.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("value " + Arrays.toString(joinPoint.getArgs()) + " set in " + joinPoint.toString());
	}
}
