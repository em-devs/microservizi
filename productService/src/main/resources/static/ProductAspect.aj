package it.eng.productService.aspects;

import org.jboss.logging.Logger;

import it.eng.productService.controller.ProductServiceController;

public aspect ProductAspect {
	
	private Logger log = Logger.getLogger(ProductServiceController.class);
	
	//pointcut callGetAllProducts() : execution(List<Products> ProductServiceController.getAllProducts());
	
	before() : callGetAllProducts() {
		log.info("BEFORE METHOD getAllProducts()");
	}
	
	/*
    boolean around(int amount, Account acc) : 
      callWithDraw(amount, acc) {
        if (acc.balance < amount) {
            return false;
        }
        return proceed(amount, acc);
    }
    */
 
    after() : callGetAllProducts() {
    	log.info("AFTER METHOD getAllProducts()");
    }
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE aspectj PUBLIC
    "-//AspectJ//DTD//EN" "http://www.eclipse.org/aspectj/dtd/aspectj.dtd">
<aspectj>
	<weaver
		options="-Xset:weaveJavaxPackages=true -verbose -showWeaveInfo">
		<!-- only weave classes in this package -->
		<include within="it.eng.productservice.*" />
	</weaver>
	<aspects>
		<!-- use only this aspect for weaving -->
		<aspect name="it.eng.productservice.logging.LoggingAspect" />
	</aspects>
</aspectj>