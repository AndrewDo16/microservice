package ru.programming.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.programming.productservice.model.Product;

import java.math.BigDecimal;

public interface ProductRepository extends MongoRepository<Product, String> {
}
