package com.insignis.location.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.location.dto.ProductLocationDTO;
import com.insignis.location.mapper.ProductLocationDTOMapper;
import com.insignis.location.model.Location;
import com.insignis.location.model.Product;
import com.insignis.location.service.LocationService;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/location")
public class LocationController implements BaseResources {

	private LocationService locationService;
	private ProductLocationDTOMapper mapper;

	@Autowired
	public LocationController(LocationService locationService, ProductLocationDTOMapper mapper) {
		this.locationService = locationService;
		this.mapper = mapper;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> findAll() {
		List<Location> locations = locationService.findAll();
		return locations;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = ADD_PRODUCT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody ProductLocationDTO productLocationDTO) {
		Product product = mapper.toProduct.apply(productLocationDTO);
		String location = productLocationDTO.getLocationName();
		Objects.requireNonNull(location, "Location name must not be null");
		return this.locationService.addProduct(location, product);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_PRODUCT_AT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductLocationDTO> findProductsAtLocation(@RequestParam("location") String location) {
		Objects.requireNonNull(location, "Location must not be null");
		Location loc = locationService.findByName(location).get(0);
		return loc.getProducts().stream().map(mapper.toDto).map(dto -> {
			dto.setLocationName(location);
			return dto;
		}).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_PRODUCT_ALONG_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductLocationDTO> findProductsAlongPath(@RequestParam("start") String start, @RequestParam("end") String end) {
		Objects.requireNonNull(start, "start location must not be null");
		Objects.requireNonNull(end, "end location must not be null");
		List<ProductLocationDTO> productLocations = new ArrayList<ProductLocationDTO>();
		List<Location> locations = locationService.findShortestPath(start, end);
		locations.stream().forEach(loc -> {
			productLocations.addAll(findProductsAtLocation(loc.getName()));
		});
		return productLocations;
	}

}
