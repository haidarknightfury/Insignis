package com.insignis.supplier.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.SupplierResource;
import com.insignis.supplier.domain.Supplier;
import com.insignis.supplier.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController implements SupplierResource {

	private SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Supplier create(@RequestBody Supplier supplier) {
		Supplier createdSupplier = supplierService.save(supplier);
		return createdSupplier;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Supplier delete(@RequestBody Supplier supplier) throws NotFoundException {
		Objects.requireNonNull(supplier.getId(), "Supplier ID cannot be null");
		return supplierService.delete(supplier);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Supplier update(@RequestBody Supplier supplier) {
		Objects.requireNonNull(supplier.getId(), "Supplier ID cannot be null");
		return supplierService.save(supplier);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Supplier> findAll() {
		List<Supplier> suppliers = supplierService.findAll();
		return suppliers;
	}

	@RequestMapping(value = FIND_BY_NAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> findByName(@RequestParam String name) {
		try {
			Supplier supplier = supplierService.findByName(name).get();
			ResponseEntity<Supplier> responseEntity = new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
			return responseEntity;
		} catch (Exception exception) {
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> findById(@RequestParam String id) {
		try {
			Supplier supplier = supplierService.findById(id).get();
			ResponseEntity<Supplier> responseEntity = new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
			return responseEntity;
		} catch (Exception exception) {
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
	}
}
