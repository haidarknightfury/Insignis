package com.insignis.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.insignis.product.domain.Category;
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

	public Category findByCategoryTypeEnum(String categoryType) {
		Category category = this.categoryRepository.findByCategory(categoryType);
		if (category == null) {
			return categoryRepository.save(new Category(categoryType));
		}
		return category;
	}

	public Category save(Category newCategory) {
		Assert.isTrue(!categoryRepository.existsByCategory(newCategory.getCategory()), "category already exists");
		return categoryRepository.save(newCategory);
	}

	public void delete(String categoryId) {
		Assert.isTrue(categoryRepository.existsById(categoryId), "category does not exists");
		categoryRepository.deleteById(categoryId);
	}

}
