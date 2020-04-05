package com.insignis.product.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.insignis.product.domain.CategoryTypeEnum;
import com.insignis.product.domain.Product;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setProductId("P004");
		product.setUnitPrice(135F);
		product.setName("PRODUCT 004");
		product.setCategories(Arrays.asList(categoryService.findByCategoryTypeEnum(CategoryTypeEnum.SPORTS)));
		product.setSupplierId("5e5be5625801663e5e58ba96");
		Product createdProduct = productService.createProduct(product);
		System.out.println(createdProduct.toString());
	}

}
