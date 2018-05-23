package it.dominio.productdashboardservice.business.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import it.dominio.productdashboardservice.business.transport.ProductInfo;

@RibbonClient(name="ProductService")
@FeignClient(name="ProductService")
public interface ProductServiceProxy {

	   @RequestMapping("/products")
	   public List<ProductInfo> getAllProducts();
	   
}
