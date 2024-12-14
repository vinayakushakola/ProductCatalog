package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.Entity;

@Entity(name = "tbl_Categories")
public class Category extends BaseModel{
    private String name;
}
