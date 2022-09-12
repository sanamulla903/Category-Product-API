package com.nimap.CategorySpringbootwithHibernet;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {
		
		@Autowired
		CategoryService service;
		
		@RequestMapping("/Category")
		public List<Category> list() {
		    return service.listAll();
		}
		
		@GetMapping("/Category/{id}")
		public ResponseEntity<Category> get(@PathVariable Integer id) {
		    try {
		    	Category Category = service.get(id);
		        return new ResponseEntity<Category>(Category, HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		    }      
		}
		
		@PostMapping("/Category")
		public void add(@RequestBody Category Category) {
		    service.save(Category);
		    System.out.println("Record Inserted Successfully Done...");   
		}
		
		@PutMapping("/Category/{id}")
		public ResponseEntity<?> update(@RequestBody Category Category, @PathVariable Integer id) {
		    try {
		    	Category existCategory = service.get(id);
		        service.save(Category);
		        return new ResponseEntity<>(HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    } 
		}
		
		@DeleteMapping("/Category/{id}")
		public void delete(@PathVariable Integer id) {
		    service.delete(id);
		    System.out.println("Record Deleted Successfully Done... ");
		    
		}
}
