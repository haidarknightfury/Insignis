package com.insignis.apigateway.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.apigateway.dto.Tab;
import com.insignis.apigateway.feignclient.InsignisProductClient;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/apigateway/category")
public class CategoriesController {

	private InsignisProductClient insignisProductClient;

	@Autowired
	public CategoriesController(InsignisProductClient insignisProductClient) {
		this.insignisProductClient = insignisProductClient;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tab> getCategories() {
		return insignisProductClient.findAllCategories().stream().map(cat -> {
			Tab tab = new Tab(cat.getCategory());
			return tab;
		}).collect(Collectors.toList());
	}
}
