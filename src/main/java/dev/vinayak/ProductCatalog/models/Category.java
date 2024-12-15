package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "tbl_Categories")
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
