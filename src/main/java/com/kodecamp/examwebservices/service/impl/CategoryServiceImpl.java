package com.kodecamp.examwebservices.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodecamp.examwebservices.model.exam.Category;
import com.kodecamp.examwebservices.repo.CategoryRepository;
import com.kodecamp.examwebservices.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {

		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {

		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {

		return new LinkedHashSet<>(categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long cId) {

		return this.categoryRepository.findById(cId).get();
	}

	@Override
	public void deleteCategory(Long cId) {

		Category c = new Category();
		c.setcId(cId);
		this.categoryRepository.delete(c);

	}

}
