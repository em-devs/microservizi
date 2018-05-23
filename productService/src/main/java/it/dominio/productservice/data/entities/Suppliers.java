package it.dominio.productservice.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Suppliers implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="SUPPLIER_ID", nullable=false)
    private Long       supplierId   ;
  
    @Column(name="CITY", length=255)
    private String     city         ;

    @Column(name="SUPPLIER_NAME", length=255)
    private String     supplierName ;

    @OneToMany(mappedBy="suppliers", targetEntity=SupplierProducts.class)
    private List<SupplierProducts> listOfSupplierProducts;

    public Suppliers()
    {
		super();
    }

    public void setSupplierId( Long supplierId )
    {
        this.supplierId = supplierId ;
    }
    public Long getSupplierId()
    {
        return this.supplierId;
    }

    public void setCity( String city )
    {
        this.city = city;
    }
    public String getCity()
    {
        return this.city;
    }

    public void setSupplierName( String supplierName )
    {
        this.supplierName = supplierName;
    }
    public String getSupplierName()
    {
        return this.supplierName;
    }

    public void setListOfSupplierProducts( List<SupplierProducts> listOfSupplierProducts )
    {
        this.listOfSupplierProducts = listOfSupplierProducts;
    }
    public List<SupplierProducts> getListOfSupplierProducts()
    {
        return this.listOfSupplierProducts;
    }

    public String toString() { 
    	StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(supplierId);
        sb.append("]:"); 
        sb.append(city);
        sb.append("|");
        sb.append(supplierName);
        return sb.toString(); 
    } 

}