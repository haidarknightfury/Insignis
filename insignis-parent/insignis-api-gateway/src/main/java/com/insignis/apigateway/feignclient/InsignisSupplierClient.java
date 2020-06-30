package com.insignis.apigateway.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insignis.shared.dto.SupplierDTO;

@FeignClient("insignis-supplier")
public interface InsignisSupplierClient {

	@RequestMapping(value = "/supplier/findAll", method = RequestMethod.GET)
	public List<SupplierDTO> findAllSuppliers();

}
