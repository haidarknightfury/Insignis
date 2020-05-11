package com.insignis.product.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.CategoryTypeEnum;
import com.insignis.product.domain.Product;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.dto.SupplierDTO;

public class MapperUtils {

	public static Function<Product, ProductDTO> ProductDTOMapper() {
		return product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setUnitPrice(product.getUnitPrice());
			productDTO.setCategories(product.getCategories().stream().map(CategoryDTOMapper()).collect(Collectors.toList()));
			SupplierDTO supplier = new SupplierDTO();
			supplier.setId(product.getSupplierId());
			productDTO.setSupplier(supplier);
			return productDTO;
		};
	}

	public static Function<ProductDTO, Product> productMapper() {
		return productDto -> {
			Product product = new Product();
			product.setId(productDto.getId());
			product.setName(productDto.getName());
			product.setUnitPrice(productDto.getUnitPrice());
			product.setSupplierId(productDto.getSupplier().getId());
			product.setCategories(productDto.getCategories().stream().map(categoryMapper()).collect(Collectors.toList()));
			return product;
		};
	}

	public static Function<CategoryDTO, Category> categoryMapper() {
		return categoryDto -> {
			Category category = new Category();
			category.setCategory(CategoryTypeEnum.valueOf(categoryDto.getCategory()));
			category.setId(categoryDto.getId());
			return category;
		};
	}

	public static Function<Category, CategoryDTO> CategoryDTOMapper() {
		return cat -> {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategory(cat.getCategory().toString());
			categoryDTO.setId(cat.getId());
			return categoryDTO;
		};
	}

}
