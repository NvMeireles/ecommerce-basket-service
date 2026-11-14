package dev.java.ecommerce.basketservice.service;

import dev.java.ecommerce.basketservice.client.PlatziProductResponse;
import dev.java.ecommerce.basketservice.client.PlatziStoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts(){
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziProductResponse getProductById(Long productId){
        return platziStoreClient.getProductById(productId);
    }

}
