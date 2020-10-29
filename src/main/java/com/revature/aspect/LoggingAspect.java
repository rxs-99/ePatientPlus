package com.revature.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Declares that we want to use this class an aspect which modularizes some
 * concern in our application. That concern is logging in this case.
 */
@Aspect
@Component //Don't forget to make it a bean!
public class LoggingAspect {
	
	//Can't log without a Logger!
	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);

	/*
	 * When using Spring AOP, we can define "advice" (code that will be
	 * injected at points we specify) using methods within our method.
	 * 
	 * In order to achieve this, we will define several Pointcuts. Recall
	 * that a Pointcut specifies where exactly advice will be injected.
	 * 
	 * Note that when defining a Pointcut, we use what is known as a 
	 * Pointcut expression. A Pointcut expression targets several methods.
	 * Note that the reference for the expression language is the AspectJ
	 * docs.
	 */
	
	@Pointcut("within(com.revature.repository.MonsterCardRepositoryImpl)")
	public void logAllRepository() {
		
	}
	
	/*
	 * This is Before advice. But what should happen before these method
	 * executions?
	 */
	@Before(value = "logAllRepository()")
	public void logBefore(JoinPoint jp) {
		LOG.info("The " + jp.getSignature().getName() + " is about to be called.");
	}
	
}
