package com.onimurasame.productcatalog.repository;

import com.onimurasame.productcatalog.data.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
