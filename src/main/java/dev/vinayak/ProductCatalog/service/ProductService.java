package dev.vinayak.ProductCatalog.service;

import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(Long id);

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(Long id, GenericProductDto product);

    GenericProductDto createProduct(GenericProductDto product);
}
