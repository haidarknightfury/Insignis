package com.insignis.cart.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.cart.mapper.MapperUtils;
import com.insignis.cart.model.Cart;
import com.insignis.cart.service.CartService;
import com.insignis.cart.service.ProductServiceClient;
import com.insignis.cart.service.UpdateCartEntryProcessor;
import com.insignis.shared.dto.CartDTO;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/cart")
public class CartController implements BaseResources {

	private static final String DEFAULT_OUTLET = "DEFAULT";
	private final CartService cartService;
	private final ProductServiceClient productServiceClient;

	@Autowired
	public CartController(CartService cartService, ProductServiceClient productServiceClient) {
		this.cartService = cartService;
		this.productServiceClient = productServiceClient;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getAllCarts() {
		List<Cart> carts = cartService.findAll();
		return carts.stream().map(MapperUtils.toCartDTO).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO findCartById(@RequestParam String id, @RequestParam Boolean withProductDetails) {
		Cart cart = cartService.getCart(id);
		CartDTO cartDTO = MapperUtils.toCartDTO.apply(cart);
		if (withProductDetails) {
			List<ProductDTO> products = cartDTO.getProducts().stream().map(simplifiedProductDTO -> {
				ProductDTO fullProductDetails = productServiceClient.getFullProductDetails(simplifiedProductDTO.getId());
				fullProductDetails.setQuantity(simplifiedProductDTO.getQuantity());
				return fullProductDetails;
			}).collect(Collectors.toList());
			cartDTO.setProducts(products);
		}
		return cartDTO;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO createCart(@RequestBody CartDTO cartDto) {
		cartDto.setId(cartDto.getId() != null ? cartDto.getId() : UUID.randomUUID().toString());
		cartDto.setDate(new Date());
		cartDto.setOutlet(cartDto.getOutlet() != null ? cartDto.getOutlet() : DEFAULT_OUTLET);
		cartService.addCart(MapperUtils.toCart.apply(cartDto));
		return MapperUtils.toCartDTO.apply(cartService.getCart(cartDto.getId()));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO updateCart(@RequestBody CartDTO cartDto) {
		Cart cart = MapperUtils.toCart.apply(cartDto);
		Cart updated = cartService.updateCart(cartDto.getId(), new UpdateCartEntryProcessor(cart.getProducts()));
		return MapperUtils.toCartDTO.apply(updated);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO deleteCart(@RequestBody CartDTO cartDto) {
		Objects.requireNonNull(cartDto.getId(), "Cart ID cannot be null");
		cartService.deleteCart(cartDto.getId());
		return cartDto;
	}

}
