package com.insignis.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.insignis.product.domain.Product;
import com.insignis.product.mapper.MapperUtils;
import com.insignis.product.repository.ProductRepository;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.dto.SupplierDTO;
import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.SupplierResource;

@Service
@Transactional
public class ProductService implements SupplierResource {

	@Value("${application.service.supplier}")
	private String SUPPLIER_URL;

	private RestTemplate restTemplate;
	private ProductRepository productRepository;

	@Autowired
	public ProductService(RestTemplate restTemplate, ProductRepository productRepository) {
		this.restTemplate = restTemplate;
		this.productRepository = productRepository;
	}

	public List<ProductDTO> getProducts() {
		List<ProductDTO> products = this.productRepository.findAll().stream().map(MapperUtils.ProductDTOMapper()).collect(Collectors.toList());
		return products;
	}

	public Product createProduct(Product product) throws NotFoundException {
		SupplierDTO supplierDTO = getSupplierById(product.getSupplierId()).orElseThrow(() -> new NotFoundException(product.getSupplierId() + " could not be found"));
		return this.productRepository.save(product);
	}

	public Optional<SupplierDTO> getSupplierById(String suplierId) {
		ResponseEntity<SupplierDTO> response = restTemplate.getForEntity(SUPPLIER_URL + SupplierResource.FIND_BY_ID, SupplierDTO.class);
		return Optional.ofNullable(response.getBody());
	}

	public List<SupplierDTO> getSuppliers() {
		ResponseEntity<SupplierDTO[]> response = restTemplate.getForEntity(SUPPLIER_URL + SupplierResource.FIND_ALL, SupplierDTO[].class);
		SupplierDTO[] suppliers = response.getBody();
		return Arrays.stream(suppliers).collect(Collectors.toList());
	}

}
