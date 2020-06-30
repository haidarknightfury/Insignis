package com.insignis.apigateway.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;

@FeignClient("insignis-product")
public interface InsignisProductClient {

	@RequestMapping(value = "/products/findAll", method = RequestMethod.GET)
	public List<ProductDTO> findAllProducts();

	@RequestMapping(value = "/category/findAll", method = RequestMethod.GET)
	public List<CategoryDTO> findAllCategories();

	@RequestMapping(value = "/products/findByCategory", method = RequestMethod.POST)
	public List<ProductDTO> findProductsByCategory(CategoryDTO categoryDTO);
}
