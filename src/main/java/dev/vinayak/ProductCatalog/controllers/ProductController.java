package dev.vinayak.ProductCatalog.controllers;

import dev.vinayak.ProductCatalog.dtos.ExceptionDto;
import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import dev.vinayak.ProductCatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return new ResponseEntity<>(
            productService.getProductById(id),
            HttpStatus.OK
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) throws NotFoundException{
        return new ResponseEntity<>(
            productService.deleteProductById(id),
            HttpStatus.OK
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto product) throws NotFoundException{
        return new ResponseEntity<>(
                productService.updateProductById(id, product),
                HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto product){
        return new ResponseEntity<>(
                productService.createProduct(product),
                HttpStatus.OK
        );
    }
}
