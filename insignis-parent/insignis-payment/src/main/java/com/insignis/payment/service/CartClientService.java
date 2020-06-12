package com.insignis.payment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.insignis.shared.dto.CartDTO;
import com.insignis.shared.operations.BaseResources;

@Service
public class CartClientService implements BaseResources {

	private static final String CART_SERVICE = "http://insignis-cart/cart/findById/?id={id}&withProductDetails={withProductDetails}";
	private RestTemplate restTemplate;

	@Autowired
	public CartClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CartDTO getCart(String cartId) {
		Map<String, String> urlParameters = new HashMap<>();
		urlParameters.put("id", cartId);
		urlParameters.put("withProductDetails", "false");
		try {
			ResponseEntity<CartDTO> response = restTemplate.getForEntity(CART_SERVICE, CartDTO.class, urlParameters);
			return response.getBody();
		} catch (Exception exception) {
			System.out.println("Could not make request to cart service " + exception.getStackTrace());
			throw exception;
		}

	}

}
