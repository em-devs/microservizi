package it.dominio.productservice.data.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SupplierProducts implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long       supplierProductsId ;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")
    private Products products;

    @ManyToOne
    @JoinColumn(name="SUPPLIER_ID", referencedColumnName="SUPPLIER_ID")
    private Suppliers suppliers;

    public SupplierProducts()
    {
		super();
    }

    public void setSupplierProductsId( Long supplierProductsId )
    {
        this.supplierProductsId = supplierProductsId ;
    }
    public Long getSupplierProductsId()
    {
        return this.supplierProductsId;
    }

    public void setProducts( Products products )
    {
        this.products = products;
    }
    public Products getProducts()
    {
        return this.products;
    }

    public void setSuppliers( Suppliers suppliers )
    {
        this.suppliers = suppliers;
    }
    public Suppliers getSuppliers()
    {
        return this.suppliers;
    }

    public String toString() { 
    	StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(supplierProductsId);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}