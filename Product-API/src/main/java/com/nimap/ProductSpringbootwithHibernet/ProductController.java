package com.nimap.ProductSpringbootwithHibernet;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

@RestController
@RequestMapping("/api")
public class ProductController {

	
	@Autowired
	ProductService service;
	
	@RequestMapping("/products")
	public List<Product> list() {
	    return service.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
	    try {
	        Product product = service.get(id);
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
	    service.save(product);
	    System.out.println("Record Inserted Successfully Done...");   
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
	    try {
	        Product existProduct = service.get(id);
	        service.save(product);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } 
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	    System.out.println("Record Deleted Successfully Done... ");
	    
	}
}
