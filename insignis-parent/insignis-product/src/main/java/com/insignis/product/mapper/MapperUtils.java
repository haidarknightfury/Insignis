package com.insignis.product.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.Product;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;

public class MapperUtils {

	public static Function<Product, ProductDTO> ProductDTOMapper() {
		return product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(productDTO.getName());
			productDTO.setUnitPrice(product.getUnitPrice());
			productDTO.setCategories(product.getCategories().stream().map(CategoryDTOMapper()).collect(Collectors.toList()));

			return productDTO;
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
