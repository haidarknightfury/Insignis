package com.insignis.apigateway.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.apigateway.dto.Product;
import com.insignis.apigateway.feignclient.InsignisProductClient;
import com.insignis.apigateway.mapper.MapperUtils;
import com.insignis.shared.dto.CategoryDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/apigateway/product")
public class ProductController {

	private InsignisProductClient insignisProductClient;

	@Autowired
	public ProductController(InsignisProductClient insignisProductClient) {
		this.insignisProductClient = insignisProductClient;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return insignisProductClient.findAllProducts().stream().map(MapperUtils.toProduct()).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductsByCategory(@PathVariable("categoryName") String categoryName) {
		Assert.notNull(categoryName, "category cannot be null");
		return insignisProductClient.findProductsByCategory(new CategoryDTO("", categoryName)).stream().map(MapperUtils.toProduct()).collect(Collectors.toList());
	}

}
