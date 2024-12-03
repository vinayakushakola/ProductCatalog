package dev.vinayak.ProductCatalog.service;

import dev.vinayak.ProductCatalog.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import dev.vinayak.ProductCatalog.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (FakeStoreProductDto product: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtoList.add(GetGenericProductDto(product));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        return GetGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws NotFoundException {
        return GetGenericProductDto(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto product) throws NotFoundException {
        return GetGenericProductDto(fakeStoreProductServiceClient.updateProductById(id, product));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return GetGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }

    private GenericProductDto GetGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }
}
