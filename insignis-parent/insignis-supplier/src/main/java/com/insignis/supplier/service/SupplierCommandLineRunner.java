package com.insignis.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.insignis.supplier.domain.Supplier;

@Component
public class SupplierCommandLineRunner implements CommandLineRunner {

	@Autowired
	private SupplierService supplierService;
	
	@Override
	public void run(String... args) throws Exception {
//		Supplier supplier = new Supplier();
//		supplier.setName("SUPPLIER_TEST");
//		supplierService.save(supplier);
	}

}
