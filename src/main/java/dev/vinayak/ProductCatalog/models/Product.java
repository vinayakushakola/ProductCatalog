package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity(name = "tbl_products")
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    //           P : C
    // L to R => 1 : 1
    // R to L => m : 1
    // Ans    => m : 1
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    @JoinColumn(name = "price_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;
}
