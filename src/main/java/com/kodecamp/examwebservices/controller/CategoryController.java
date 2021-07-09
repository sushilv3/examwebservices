package com.kodecamp.examwebservices.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodecamp.examwebservices.model.exam.Category;
import com.kodecamp.examwebservices.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	//add category
	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody  Category category){
		
		Category addedCategory = this.categoryService.addCategory(category);
		return ResponseEntity.ok(addedCategory);
	}
	
	//get category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}
	
	//get All categories
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//update
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
//	delete
	@DeleteMapping("/{categoryId}")
	public void deleteCAtegory(@PathVariable("categoryId") Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}
}
