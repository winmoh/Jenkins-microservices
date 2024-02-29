package com.microservices.demo.Service;

import com.microservices.demo.Dto.ProductDto;
import com.microservices.demo.Model.Category;
import com.microservices.demo.Model.Product;
import com.microservices.demo.Repository.ProductRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public String addProduct(ProductDto  product){
        if(productRepository.findProductByProduct_code(product.getProduct_code()).isPresent()){
            return "product already saved";
        }
        else{
            Product prod=Product.builder()
                    .product_code(product.getProduct_code())
                    .price(product.getPrice())
                    .name(product.getName())
                    .available_quantity(product.getAvailable_quantity())
                    .product_category(product.getProduct_category()).build();
            productRepository.save(prod);
            return "product saved successfully";
        }
    }

    public Optional<Product> getProduct(long id){
        if(productRepository.findById(id).isPresent()){
            return Optional.ofNullable(productRepository.findById(id).get());

        }
        else{
            return Optional.ofNullable(productRepository.findById(id).get());
        }
    }
    public List<Product> getProductsByCategory(Category cat){
        return productRepository.findProductByProduct_category(cat);
    }

    public String deleteProductById(long id){
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return "product deleted";
        }
        else{
            return "product doesn't exist";
        }
    }
}
