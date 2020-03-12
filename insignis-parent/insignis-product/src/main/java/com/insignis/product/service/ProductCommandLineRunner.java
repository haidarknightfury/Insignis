package com.insignis.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		productService.createProduct();
	}

}
