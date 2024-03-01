package com.microservices.demo.Controller;

import com.microservices.demo.Dto.ProductDto;
import com.microservices.demo.Model.Category;
import com.microservices.demo.Model.Product;
import com.microservices.demo.Service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final WebClient.Builder webClientBuilder;
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();

    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<String>(productService.addProduct(productDto),null, HttpStatus.OK);
    }

    @GetMapping("/getProductById")
    public Optional<Product> getProductById(@RequestParam long id){
       return productService.getProduct(id);
    }

    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(Category catetgory){
        return productService.getProductsByCategory(catetgory);

    }
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam long id){
        return new ResponseEntity<String>(productService.deleteProductById(id),null,HttpStatus.OK);

    }

    @GetMapping("/order")
    public Mono<String> makeOrder(){
        Mono<String> result= webClientBuilder.build().get()
                    .uri("http://order-service/api/order").retrieve().bodyToMono(String.class);


        return result;
    }



}
