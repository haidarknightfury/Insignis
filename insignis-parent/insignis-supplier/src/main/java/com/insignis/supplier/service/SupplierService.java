package com.insignis.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insignis.shared.exception.NotFoundException;
import com.insignis.supplier.domain.Supplier;
import com.insignis.supplier.repository.SupplierRepository;


@Service
@Transactional
public class SupplierService {
	
	
	private SupplierRepository supplierRepository;
		
	@Autowired
	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> findAll(){
		return supplierRepository.findAll();
	}
	
	
	public Supplier delete(Supplier supplier) throws NotFoundException {
		 Optional<Supplier> mongoSupplier = supplierRepository.findById(supplier.getId());
		 if(mongoSupplier.isPresent()) {
			 Supplier sup = mongoSupplier.get();
			 supplierRepository.delete(sup);
			 return sup;
		 }
		 throw new NotFoundException("Supplier could not be found");
	}
	
	

}
