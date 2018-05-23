package it.dominio.productdashboardservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import it.dominio.productdashboardservice.business.proxy.ProductServiceProxy;
import it.dominio.productdashboardservice.business.transport.ProductInfo;

@RefreshScope
@RestController
@Api(value = "Products Dashboard", description = "REST API for Products Dashboard Management", tags = { "Products Dashboard" })
public class ProductDashboardServiceController {

	@Autowired
	ProductServiceProxy proxyService;

	@RequestMapping("/dashboard/products")
	@HystrixCommand(fallbackMethod="defaultProducts")
	public List<ProductInfo> findProducts() {
		return proxyService.getAllProducts();
	}
	
	@SuppressWarnings("unused")
	private List<ProductInfo> defaultProducts() {
		ProductInfo prod1 = new ProductInfo();
		ProductInfo prod2 = new ProductInfo();
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		
		prod1.setProductId(99998L);
		prod1.setProductName("def_name_1");
		prod1.setCategory("def_cat_1");
		prod2.setProductId(99999L);
		prod2.setProductName("def_name_2");
		prod2.setCategory("def_cat_2");

		list.add(prod1);
		list.add(prod2);
		return list;
	}
	

}
