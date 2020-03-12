package com.insignis.product.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.insignis.shared.dto.SupplierDTO;

@Service
public class ProductService {

	private RestTemplate restTemplate;

	@Autowired
	public ProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void createProduct() {

		ResponseEntity<SupplierDTO[]> response = restTemplate.getForEntity("http://localhost:8085/supplier/findAll",
				SupplierDTO[].class);
		SupplierDTO[] suppliers = response.getBody();
		System.out.println(suppliers);

		Arrays.stream(suppliers).forEach(System.out::println);

//		List<SupplierDTO> suppliers = restTemplate.exchange(new URI("http://localhost:8085/supplier/findAll"), HttpMethod.GET, null	, SupplierDTO.class);
	}

}
