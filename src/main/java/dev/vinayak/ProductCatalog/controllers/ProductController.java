package dev.vinayak.ProductCatalog.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    @GetMapping()
    public String getAllProducts(){
        return "Hello People";
    }

    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "Hello People " + id;
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }

    @PostMapping()
    public void createProduct(){

    }
}
