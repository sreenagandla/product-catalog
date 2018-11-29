package com.onimurasame.productcatalog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onimurasame.productcatalog.data.Product;
import com.onimurasame.productcatalog.exception.CustomException;
import com.onimurasame.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    ResponseEntity<String> getProducts() throws JsonProcessingException {

        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(productList), HttpStatus.OK);
    }

    @GetMapping("/exception")
    void getException() throws CustomException {
        throw new CustomException();
    }

}
