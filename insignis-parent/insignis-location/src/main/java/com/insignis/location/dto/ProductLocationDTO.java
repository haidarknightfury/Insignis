package com.insignis.location.dto;

import java.util.List;

import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.dto.SupplierDTO;

public class ProductLocationDTO extends ProductDTO {

	private static final long serialVersionUID = 1L;
	private String locationName;

	public ProductLocationDTO(String id, String productId, String name, Float unitPrice, List<CategoryDTO> categories, SupplierDTO supplier, String locationName) {
		super(id, productId, name, unitPrice, categories, supplier);
		this.locationName = locationName;
	}

	public ProductLocationDTO() {
		super();
	}

	public ProductLocationDTO(String id, String productId, String name, Float unitPrice, List<CategoryDTO> categories, SupplierDTO supplier) {
		super(id, productId, name, unitPrice, categories, supplier);
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
