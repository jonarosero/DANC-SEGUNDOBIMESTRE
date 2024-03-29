package tec.utpl.store.serviceshopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import tec.utpl.store.serviceshopping.model.Product;

@Entity
@Data
@Table(name="tbl_invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;
    private Double  price;


    @Column(name = "product_id")
    private Long productId;


    @Transient
    private Double subTotal;
    @Transient
    private Product product;

    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;

    }
}
