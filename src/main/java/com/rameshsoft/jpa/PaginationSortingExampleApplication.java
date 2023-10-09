package com.rameshsoft.jpa;

import com.rameshsoft.jpa.dto.APIResponse;
import com.rameshsoft.jpa.entity.Product;
import com.rameshsoft.jpa.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class PaginationSortingExampleApplication {
	@Autowired
	private Productservice productservice;
	@GetMapping
	private APIResponse<List<Product>> getProducts(){
		List<Product> allProducts = productservice.findAllProducts();
		return  new APIResponse<>(allProducts.size(), allProducts);  //to get all the products present in db
	}
//Get records based on field sorting
	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field){
		List<Product> allProducts = productservice.findProductsWithSorting(field);
		return  new APIResponse<>(allProducts.size(), allProducts);  //to get all the products present in db
	}
	//pagination
	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
		Page<Product> productsWithPagination = productservice.findProductsWithPagination(offset, pageSize);
		return  new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);  //to get all the products present in db
	}
//PaginationAndSort
	@GetMapping("/paginationAndSorting/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		Page<Product> productsWithPagination = productservice.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return  new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);  //to get all the products present in db
	}


	public static void main(String[] args) {
		SpringApplication.run(PaginationSortingExampleApplication.class, args);
	}

}
