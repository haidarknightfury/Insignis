package com.insignis.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insignis.location.model.Location;
import com.insignis.location.model.Product;
import com.insignis.location.repository.LocationRepository;

@Service
public class LocationService {

	private LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public List<Location> findByName(String name) {
		return locationRepository.findByName(name);
	}

	public Product addProduct(String locationName, Product product) {
		Location location = findByName(locationName).get(0);
		location.getProducts().add(product);
		locationRepository.save(location);
		return locationRepository.findByName(locationName).get(0).getProducts().stream().filter(prod -> prod.getProductName() == product.getProductName()).findAny().get();
	}
}
