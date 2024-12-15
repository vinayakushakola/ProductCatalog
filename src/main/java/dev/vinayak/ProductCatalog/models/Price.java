package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_Price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel {
    String currency;
    double price;
}
