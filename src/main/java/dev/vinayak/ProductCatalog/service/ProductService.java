package dev.vinayak.ProductCatalog.service;

import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import dev.vinayak.ProductCatalog.models.Product;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(Long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) throws NotFoundException;
    GenericProductDto deleteProductById(Long id) throws NotFoundException;
}
