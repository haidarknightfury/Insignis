package com.insignis.cart.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.cart.mapper.MapperUtils;
import com.insignis.cart.model.Cart;
import com.insignis.cart.service.CartService;
import com.insignis.shared.dto.CartDTO;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private List<CartDTO> getAllCarts() {
		List<Cart> carts = cartService.findAll();
		return carts.stream().map(MapperUtils.toCartDTO).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO createCart(@RequestBody CartDTO cartDto) {
		cartDto.setId(UUID.randomUUID().toString());
		cartService.addCart(MapperUtils.toCart.apply(cartDto));
		return cartDto;
	}

}
