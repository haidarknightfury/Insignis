package com.insignis.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.CategoryTypeEnum;
import com.insignis.product.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findCategories() {
		return this.categoryRepository.findAll();
	}

	public Category create(Category category) {
		return this.categoryRepository.save(category);
	}

	public Category findByCategoryTypeEnum(CategoryTypeEnum categoryTypeEnum) {
		Category category = this.categoryRepository.findByCategory(categoryTypeEnum);
		if (category == null) {
			return categoryRepository.save(new Category(categoryTypeEnum));
		}
		return category;
	}

}
