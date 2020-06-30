package com.insignis.apigateway.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.insignis.apigateway.feignclient.InsignisProductClient;
import com.insignis.apigateway.feignclient.InsignisSupplierClient;
import com.insignis.apigateway.model.Role;
import com.insignis.apigateway.model.RoleEnum;
import com.insignis.apigateway.repository.RoleRepository;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.dto.SupplierDTO;

@Component
public class InitialisationService implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private InsignisSupplierClient insignisSupplierClient;

	@Autowired
	private InsignisProductClient insignisProductClient;

	@Value("${insignis.app.generateRoles}")
	private Boolean generateRoles;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("generate roles in db : " + generateRoles);
		if (generateRoles) {
			roleRepository.deleteAll();
			Arrays.asList(RoleEnum.values()).stream().forEach(role -> {
				roleRepository.save(new Role(role));
			});
		}

		System.out.println("testing feign clients");
		List<SupplierDTO> suppliers = insignisSupplierClient.findAllSuppliers();
		System.out.println(suppliers);

		System.out.println("testing product client");
		List<ProductDTO> products = insignisProductClient.findAllProducts();
		System.out.println(products);

//		System.out.println("Finding by category");
//		List<ProductDTO> productByCategory = insignisProductClient.findProductsByCategory(new CategoryDTO("", "SPORTS"));
//		System.out.println(productByCategory);

	}

}
