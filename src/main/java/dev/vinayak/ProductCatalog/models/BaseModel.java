package dev.vinayak.ProductCatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
/*
@MappedSuperclass
1. No table for parent class
2. All child classes will have a table
3. Child tables will have attr of parent class
4. Typically this is used when parent class is abstract

@SingleTable
1. Only one table have columns of all of the child classes
2. One new col to identify type (differentiator)
3. Very bad idea (exists)
 */
public class BaseModel {
    @Id
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID id;
}
