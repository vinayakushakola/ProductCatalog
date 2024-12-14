package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "tbl_products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    //           P : C
    // L to R => 1 : 1
    // R to L => m : 1
    // Ans    => m : 1
    @ManyToOne
    private Category category;
    private int price;
}
