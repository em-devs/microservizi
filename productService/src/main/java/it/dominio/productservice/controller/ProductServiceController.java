package it.dominio.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.dominio.productservice.business.service.ProductsService;
import it.dominio.productservice.business.transport.ProductsDTO;
import it.dominio.productservice.logging.Monitored;

@Monitored
@RefreshScope
@RestController
@Api(value = "Products", description = "REST API for Products Management", tags = { "Products" })
public class ProductServiceController {
	
	static final Logger log = LogManager.getLogger(ProductServiceController.class);

	@Value("${name}")
    private String productName;
	
	@Autowired
	ProductsService productsService;
	
    @RequestMapping("/product")
    public String getProductName(){
       
        return "hello " + productName;
    }

	// Get All Products
    @GetMapping("/products")
	public List<ProductsDTO> getAllProducts() {
    	return productsService.findAll();
	}
	
	// Create a new Product
	@PostMapping("/products")
	public ProductsDTO createProduct(@Valid @RequestBody ProductsDTO product) {
		return productsService.save(product);
	}

	// Get a Single Product
	@GetMapping("/product/{id}")
	public ProductsDTO getProduct(@PathVariable("id") String productId) {
		Long productIdLong = Long.parseLong(productId);
		return productsService.findById(productIdLong);
	}

	// Update a Product

	// Delete a Product
	
}
