package com.bankonet.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("MyAspect")
@Aspect
public class LogAspect {

private Log log = LogFactory.getLog(this.getClass());
final String pointCut = "execution(* com.bankonet.metier.*.*(..)) ||execution(* com.bankonet.dao.*.*(..)) ";
final String pointCut2 = "execution(* com.bankonet.dao.*.*(..)) ";

@Before(pointCut)
@Order(0)
public void logBefore(JoinPoint point){
	System.out.println("----AOP---- Before--- " + point.getTarget().getClass()+", "
			+ "Méthode " + point.getSignature().getName()+", "
					+ "Paramètres de la méthode"+ Arrays.toString(point.getArgs()));
	}
@AfterReturning(pointcut = pointCut,returning="result")
@Order(1)
public void logAfter(JoinPoint point,Object result){
	System.out.println("----AOP----AfterReturning----" + point.getTarget().getClass()+"."
			+point.getSignature().getName()+"() returning " + result);
}

@Around(pointCut)
@Order(2)
public Object logAround(ProceedingJoinPoint point) throws Throwable{
	 log.info("----AOP----Around---- "+ point.getSignature().getName()+"() invoquée avec" +Arrays.toString(point.getArgs()));
	try {
		Object result = point.proceed();
		log.info("----AOP----Around---- " + point.getTarget().getClass()+"."
			+point.getSignature().getName()+"() returning " + result);
	return result;
	} catch (IllegalArgumentException e) {
		log.error("----AOP----Around---- Argument invalide "+Arrays.toString(point.getArgs())+" dans"
				+point.getSignature().getName()+"()");
		throw e;
	}
}

@AfterThrowing(pointcut = pointCut,throwing="e")
public void logAfterThrowing(JoinPoint point, Throwable e){
	log.error("----AOP----AfterThrowing----Exception "+ e + " lancée dans " + point.getSignature().getName()+"()");
	}
}
