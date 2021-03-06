/*
 * Created on 2018-04-21 ( Time 14:33:57 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package it.dominio.productservice.business.service;

import java.util.List;

import it.dominio.productservice.business.transport.ProductsDTO;

/**
 * Business Service Interface for entity Products.
 */
public interface ProductsService { 
	
	/**
	 * Loads an entity from the database using its Primary Key
	 * @param productId
	 * @return entity
	 */
	ProductsDTO findById( Long productId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<ProductsDTO> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	ProductsDTO save(ProductsDTO entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	ProductsDTO update(ProductsDTO entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	ProductsDTO create(ProductsDTO entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param productId
	 */
	void delete( Long productId );


}
