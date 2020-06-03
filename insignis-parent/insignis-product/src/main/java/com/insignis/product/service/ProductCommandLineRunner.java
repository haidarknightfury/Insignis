package com.insignis.product.service;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.insignis.shared.dto.SupplierDTO;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	@Qualifier("productRestTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setProductId("P004");
//		product.setUnitPrice(135F);
//		product.setName("PRODUCT 004");
//		product.setCategories(Arrays.asList(categoryService.findByCategoryTypeEnum(CategoryTypeEnum.SPORTS)));
//		product.setSupplierId("5e5be5625801663e5e58ba96");
//		Product createdProduct = productService.save(product);
//		System.out.println(createdProduct.toString());

		discoveryClient.getInstances("insignis-supplier").forEach((ServiceInstance s) -> {
			System.out.println(ToStringBuilder.reflectionToString(s));
		});

		ResponseEntity<SupplierDTO[]> response = restTemplate.getForEntity("http://insignis-supplier/supplier/findAll", SupplierDTO[].class);
		SupplierDTO[] suppliers = response.getBody();
		System.out.println(suppliers);

	}

}
