package com.insignis.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.location.model.Location;
import com.insignis.location.service.LocationService;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/location")
public class LocationController implements BaseResources {

	private LocationService locationService;

	@Autowired
	public LocationController(LocationService locationService) {

		this.locationService = locationService;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> findAll() {
		List<Location> locations = locationService.findAll();
		return locations;

	}

}
