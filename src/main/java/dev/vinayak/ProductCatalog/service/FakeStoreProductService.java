package dev.vinayak.ProductCatalog.service;

import dev.vinayak.ProductCatalog.dtos.FakeStoreProductDto;
import dev.vinayak.ProductCatalog.dtos.GenericProductDto;
import dev.vinayak.ProductCatalog.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String baseRequestUrl = "https://fakestoreapi.com/products/";
    private String specificRequestUrl = baseRequestUrl + "{id}";
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(baseRequestUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> lstProduct = new ArrayList<>();
        for (FakeStoreProductDto product : response.getBody()) {
            lstProduct.add(GetGenericProductDto(product));
        }
        return lstProduct;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null){
            throw new NotFoundException("Product with id "+id+" doesn't exist");
        }
        return GetGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(baseRequestUrl, genericProductDto, FakeStoreProductDto.class);
        return GetGenericProductDto(response.getBody());
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) throws NotFoundException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDto, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor,
                id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null){
            throw new NotFoundException("Product with id "+id+" doesn't exist");
        }
        return GetGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws NotFoundException {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificRequestUrl,
                HttpMethod.DELETE, requestCallback, responseExtractor, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null){
            throw new NotFoundException("Product with id "+id+" doesn't exist");
        }
        return GetGenericProductDto(fakeStoreProductDto);
    }

    private GenericProductDto GetGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }
}
