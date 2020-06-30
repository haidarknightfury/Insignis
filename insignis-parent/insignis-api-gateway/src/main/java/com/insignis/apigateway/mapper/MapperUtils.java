package com.insignis.apigateway.mapper;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.apigateway.dto.Product;
import com.insignis.apigateway.dto.Tab;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;

public class MapperUtils {

	public static Function<ProductDTO, Product> toProduct() {
		return (productDto) -> {
			Product product = new Product();
			product.setName(productDto.getName());
			product.setCostPrice(productDto.getUnitPrice() != null ? productDto.getUnitPrice().intValue() : null);
			product.setDiscount(productDto.getDiscount() != null ? productDto.getDiscount().intValue() : null);
			product.setOffer(productDto.getOffer());
			product.setStock(productDto.getStock());
			product.setDescription(product.getDescription());
			product.setImage(productDto.getImage() != null ? productDto.getImage().stream().map(mapImages()).collect(Collectors.toList()) : new ArrayList<String>());
			product.setCurrency(productDto.getCurrency());
			product.setBought(productDto.getBought());
			product.setColor(productDto.getColor());
			product.setSize(productDto.getSize());
			product.setSpecs(productDto.getSpecs());
			product.setCategory(productDto.getCategories().stream().map(CategoryDTOTabMapper()).collect(Collectors.toList()));
			return product;
		};
	}

	private static Function<CategoryDTO, Tab> CategoryDTOTabMapper() {
		return (cat) -> {
			Tab tab = new Tab(cat.getCategory());
			return tab;
		};
	}

	public static Function<String, String> mapImages() {
		return (str) -> {
			return "assets/images/products/" + str;
		};
	}

}
