package com.insignis.location.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.insignis.location.dto.ProductLocationDTO;
import com.insignis.location.model.Product;
import com.insignis.location.service.LocationService;

@Component
public class ProductLocationDTOMapper {

	private LocationService locationService;

	public ProductLocationDTOMapper(LocationService locationService) {
		this.locationService = locationService;
	}

	public Function<ProductLocationDTO, Product> toProduct = (prodDTO) -> {
		Product product = new Product();
		product.setProductId(prodDTO.getId());
		product.setProductName(prodDTO.getName());
		product.setUnitPrice(prodDTO.getUnitPrice());
		return product;
	};

	public Function<Product, ProductLocationDTO> toDto = (prod) -> {
		ProductLocationDTO productLocationDTO = new ProductLocationDTO();
		productLocationDTO.setId(prod.getProductId());
		productLocationDTO.setName(prod.getProductName());
		productLocationDTO.setUnitPrice(prod.getUnitPrice());
		return productLocationDTO;
	};

}
