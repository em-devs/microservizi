package it.dominio.productservice.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	static final Logger log = LogManager.getLogger("custom");

	@Before("PointcutsDictionary.anyExecController()")
	public void anyExecController(JoinPoint joinPoint) {
		getLoggerFromJP(joinPoint).info(">>>> Before " + joinPoint.getKind() + ": " + joinPoint.getSignature().toShortString());
	}

	/*
	 * Operations during the execution of either an annotated method or a method in
	 * annotated class.
	 */
	@Around("PointcutsDictionary.monitored()")
	public Object aroundMonitored(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		getLoggerFromJP(joinPoint).info("Time Taken by {} is {} ms.", joinPoint.getSignature().toShortString(), timeTaken);
		return obj;
	}

	/*
	 * @AfterThrowing - Executed only when a method throws an exception.
	 */
	@AfterThrowing(pointcut = "PointcutsDictionary.monitored()", throwing = "exc")
	public void afterMonitored(JoinPoint joinPoint, Exception exc) {
		getLoggerFromJP(joinPoint).error("{} threw exception {}", joinPoint.getSignature().toShortString(), exc.getMessage());
	}
	
	private Logger getLoggerFromJP(JoinPoint joinPoint){
		return LogManager.getLogger(joinPoint.getTarget().getClass());
	}

}