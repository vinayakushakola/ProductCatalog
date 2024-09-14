package dev.vinayak.ProductCatalog.controllers;

import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import dev.vinayak.ProductCatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    ProductService productService;
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto) throws NotFoundException {
        return productService.updateProductById(id, genericProductDto);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.deleteProductById(id);
    }
}
