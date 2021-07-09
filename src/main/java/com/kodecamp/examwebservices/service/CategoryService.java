package com.kodecamp.examwebservices.service;

import java.util.Set;

import com.kodecamp.examwebservices.model.exam.Category;

public interface CategoryService {

	// add category
	public Category addCategory(Category category);

	// update one
	public Category updateCategory(Category category);

	// get all category
	public Set<Category> getCategories();

	// get one
	public Category getCategory(Long cId);
	
	//delete 
	public void deleteCategory(Long cId);

}
