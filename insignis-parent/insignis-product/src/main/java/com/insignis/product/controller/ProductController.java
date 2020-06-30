package com.insignis.product.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.Product;
import com.insignis.product.mapper.MapperUtils;
import com.insignis.product.service.ProductService;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.exception.InvalidParameterException;
import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.ProductResource;

@RestController
@RequestMapping(value = "/products", name = "productController")
public class ProductController implements ProductResource {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO create(@RequestBody ProductDTO productDto) throws NotFoundException {
		Product newProduct = MapperUtils.productMapper().apply(productDto);
		Product createdProduct = productService.save(newProduct);
		return MapperUtils.ProductDTOMapper().apply(createdProduct);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO update(@RequestBody ProductDTO productDTO) throws NotFoundException {
		Objects.requireNonNull(productDTO.getId(), "Product ID cannot be null");
		Product savedProduct = productService.save(MapperUtils.productMapper().apply(productDTO));
		return MapperUtils.ProductDTOMapper().apply(savedProduct);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO delete(@RequestBody ProductDTO productDTO) throws NotFoundException {
		Objects.requireNonNull(productDTO.getId(), "Product ID cannot be null");
		productService.deleteProduct(productDTO.getId());
		return productDTO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> findAll() {
		List<ProductDTO> products = productService.getProducts();
		return products;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findByCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> findByCategory(@RequestBody CategoryDTO categoryDto) {
		Category category = MapperUtils.categoryMapper().apply(categoryDto);
		List<Product> products = productService.findByCategory(category);
		return products.stream().map(MapperUtils.ProductDTOMapper()).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_BY_NAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> findByName(@RequestParam String name) {
		ResponseEntity<ProductDTO> response = ResponseEntity.ok(productService.findByProductName(name));
		return response;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> findById(@RequestParam String id) {
		ResponseEntity<ProductDTO> response = ResponseEntity.ok(MapperUtils.ProductDTOMapper().apply(productService.findProductById(id)));
		return response;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = UPDATE_STOCK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> updateStock(@RequestBody ProductDTO productDTO) throws InvalidParameterException, NotFoundException {
		Objects.requireNonNull(productDTO.getId(), "Product ID must not be null");
		Objects.requireNonNull(productDTO.getQuantity(), "Quantity bought should be available");
		Product product = productService.updateStock(productDTO.getId(), productDTO.getQuantity());
		return ResponseEntity.ok(MapperUtils.ProductDTOMapper().apply(product));
	}

}
