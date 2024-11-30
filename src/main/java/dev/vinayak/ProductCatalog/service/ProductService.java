package dev.vinayak.ProductCatalog.service;

import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import dev.vinayak.ProductCatalog.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto deleteProductById(Long id) throws NotFoundException;

    GenericProductDto updateProductById(Long id, GenericProductDto product) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);
}
