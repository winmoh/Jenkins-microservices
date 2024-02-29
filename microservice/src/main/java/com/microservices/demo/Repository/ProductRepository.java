package com.microservices.demo.Repository;

import com.microservices.demo.Model.Category;
import com.microservices.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductByProduct_code(String code);
    List<Product> findProductByProduct_category(Category cat);
}


