/*
 * Created on 2018-04-21 ( Time 21:29:41 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package it.dominio.productservice.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import it.dominio.productservice.business.transport.ProductsDTO;
import it.dominio.productservice.data.entities.Products;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProductsServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ProductsServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ProductsEntity' to 'Products'
	 * @param productsEntity
	 */
	public ProductsDTO mapProductsEntityToProducts(Products productsEntity) {
		if(productsEntity == null) {
			return null;
		}

		//--- Generic mapping 
		return  map(productsEntity, ProductsDTO.class);
	}
	
	/**
	 * Mapping from 'Products' to 'ProductsEntity'
	 * @param products
	 * @param productsEntity
	 */
	public void mapProductsToProductsEntity(ProductsDTO products, Products productsEntity) {
		if(products == null) {
			return;
		}

		//--- Generic mapping 
		map(products, productsEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}