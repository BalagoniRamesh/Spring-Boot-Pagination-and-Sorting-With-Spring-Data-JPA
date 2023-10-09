package com.rameshsoft.jpa.service;

import com.rameshsoft.jpa.entity.Product;
import com.rameshsoft.jpa.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Productservice {
    @Autowired
    private ProductRepository repository;
//    @PostConstruct   //pre-processing logic with PostConstruct, it execute at the time of start of project
//    private void initDB(){
//        List<Product> products = IntStream.rangeClosed(1,200)
//                .mapToObj(i-> new Product("product"+i, new Random().nextInt(100), new Random().nextInt(50000)))//randomly created 200 product object
//                .collect(Collectors.toList());
//        repository.saveAll(products);
//    }
    public List<Product> findAllProducts(){  //getMethod or to load all products from database
        return repository.findAll();
    }

    //Method for sorting based on field Asc/Dsc, sort dynamically any field
    public List<Product> findProductsWithSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
//spring data JPA take care this pagination and offset based on PageRequest class
    public Page<Product> findProductsWithPagination(int offset, int pageSize){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }
    //Pagination and Sorting in at a time
    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }

}
