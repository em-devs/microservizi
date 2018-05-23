package it.dominio.productservice.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Products implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="PRODUCT_ID", nullable=false)
    private Long       productId    ;

    private String     category     ;

    private String     productName  ;

    @OneToMany(mappedBy="products", targetEntity=SupplierProducts.class)
    private List<SupplierProducts> listOfSupplierProducts;

    public void setProductId( Long productId )
    {
        this.productId = productId ;
    }
    public Long getProductId()
    {
        return this.productId;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }
    public String getCategory()
    {
        return this.category;
    }

    public void setProductName( String productName )
    {
        this.productName = productName;
    }
    public String getProductName()
    {
        return this.productName;
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
        sb.append(productId);
        sb.append("]:"); 
        sb.append(category);
        sb.append("|");
        sb.append(productName);
        return sb.toString(); 
    } 

}