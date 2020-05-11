package com.insignis.cart.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.cart.model.Cart;
import com.insignis.cart.model.Product;
import com.insignis.shared.dto.CartDTO;
import com.insignis.shared.dto.ProductDTO;

public class MapperUtils {

	public static Function<Product, ProductDTO> toProductDTO = (product) -> {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setUnitPrice(product.getUnitPrice().floatValue());
		return productDTO;
	};

	public static Function<Cart, CartDTO> toCartDTO = (cart) -> {
		CartDTO cartDTO = new CartDTO(cart.getId(), cart.getTotal(), cart.getProducts().stream().map(toProductDTO).collect(Collectors.toList()));
		return cartDTO;
	};

	private static Function<ProductDTO, Product> toProduct = productDto -> {
		Product product = new Product(productDto.getId(), productDto.getName(), null, new BigDecimal(productDto.getUnitPrice()));
		return product;
	};

	public static Function<CartDTO, Cart> toCart = (cartDto) -> {
		List<Product> products = cartDto.getProducts().stream().map(toProduct).collect(Collectors.toList());
		Cart cart = new Cart(cartDto.getId(), products, cartDto.getTotal());
		return cart;
	};

}
