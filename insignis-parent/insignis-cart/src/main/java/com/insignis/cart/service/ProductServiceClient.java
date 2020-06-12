package com.insignis.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.operations.ProductResource;

@Service
public class ProductServiceClient implements ProductResource {

	private static final String PRODUCT_SERVICE_URL = "http://insignis-product/products";
	private RestTemplate restTemplate;

	@Autowired
	public ProductServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ProductDTO updateProductStock(String id, Integer quantity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO.setQuantity(quantity);
		ResponseEntity<ProductDTO> response = restTemplate.postForEntity(PRODUCT_SERVICE_URL + UPDATE_STOCK, productDTO, ProductDTO.class);
		return response.getBody();
	}

	public ProductDTO getFullProductDetails(String id) {
		ResponseEntity<ProductDTO> response = restTemplate.getForEntity(PRODUCT_SERVICE_URL + FIND_BY_ID + "?id=" + id, ProductDTO.class);
		return response.getStatusCode().equals(HttpStatus.OK) ? response.getBody() : null;
	}

}
