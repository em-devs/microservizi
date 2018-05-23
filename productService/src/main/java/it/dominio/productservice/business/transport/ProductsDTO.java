package it.dominio.productservice.business.transport;

import java.io.Serializable;

public class ProductsDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long productId    ; // Id or Primary Key

    private String     category     ;
    private String     productName  ;

    public ProductsDTO() {
        super();
    }

	public void setProductId( Long productId ) {
        this.productId = productId ;
    }

	public Long getProductId() {
        return this.productId;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(productId);
        sb.append("|");
        sb.append(category);
        sb.append("|");
        sb.append(productName);
        return sb.toString(); 
    } 

}
