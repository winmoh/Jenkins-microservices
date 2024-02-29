package com.microservices.demo.Repository;

import com.microservices.demo.Model.Category;
import com.microservices.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductByCode(String code);
    List<Product> findProductByCategory(Category cat);
}


