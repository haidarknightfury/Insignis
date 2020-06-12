package com.insignis.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.product.domain.Category;
import com.insignis.product.mapper.MapperUtils;
import com.insignis.product.service.CategoryService;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/category", name = "categoryController")
public class CategoryController implements BaseResources {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoryDTO create(@RequestBody CategoryDTO categoryDTO) throws NotFoundException {
		Category newCategory = MapperUtils.categoryMapper().apply(categoryDTO);
		Category createdCategory = categoryService.save(newCategory);
		return MapperUtils.CategoryDTOMapper().apply(createdCategory);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoryDTO delete(@RequestBody CategoryDTO categoryDTO) throws NotFoundException {
		Assert.notNull(categoryDTO.getId(), "Category ID cannot be null");
		categoryService.delete(categoryDTO.getId());
		return categoryDTO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryDTO> findAll() {
		List<Category> categories = categoryService.findCategories();
		return categories.stream().map(MapperUtils.CategoryDTOMapper()).collect(Collectors.toList());
	}

}
