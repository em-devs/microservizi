package it.dominio.productservice.logging;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutsDictionary {
	
	@Pointcut("execution(* it.dominio.productservice.controller.ProductServiceController.*(..))")
	void anyExecController() {
	}

	@Pointcut("within(@Monitored *)")
	public void monitoredClass() {
	}

	@Pointcut("execution(public * *(..))")
	public void publicMethod() {
	}

	@Pointcut("(monitoredClass() && publicMethod()) || @annotation(Monitored)")
	public void monitored() {
	}
}
