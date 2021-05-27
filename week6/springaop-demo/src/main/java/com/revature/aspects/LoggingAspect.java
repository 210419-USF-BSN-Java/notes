package com.revature.aspects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.User;

@Component
@Aspect
public class LoggingAspect {
	
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	@After("execution(void set*(..))")
	public void logSetterMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked a setter.");
	}
	
	@AfterThrowing(pointcut ="execution(void doWork(..))", throwing="exception")
	public void logAfterException(JoinPoint jp, Exception exception) {
		log.error(jp.getSignature() + " threw " + exception.getClass());
	}
	
	@Around("execution(void doWork(..))")
	public void messingAroundWithDoWork(ProceedingJoinPoint pjp) throws Throwable {
		User u = (User) pjp.getTarget();
		log.info(u.getName() + " is pondering whether or not to do work.");
		if(u.getName().equals("Robbie")) {
			log.warn("Robbie is always tired.");
		}else {
			pjp.proceed();
			log.info("This is happening after the method execution.");
		}
	}
}
