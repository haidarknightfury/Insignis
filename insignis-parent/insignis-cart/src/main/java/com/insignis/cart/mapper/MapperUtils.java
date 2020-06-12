package com.insignis.cart.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
		productDTO.setUnitPrice(product.getUnitPrice() != null ? product.getUnitPrice().floatValue() : null);
		productDTO.setQuantity(product.getQuantity());
		productDTO.setDescription(product.getDescription());
		productDTO.setProductId(product.getProductCode());
		productDTO.setBuyingPrice(product.getBuyingPrice() != null ? product.getBuyingPrice().floatValue() : null);
		productDTO.setDiscount(product.getDiscount());
		return productDTO;
	};

	public static Function<Cart, CartDTO> toCartDTO = (cart) -> {
		CartDTO cartDTO = new CartDTO(cart.getId(), cart.getTotal(), cart.getProducts().stream().map(toProductDTO).collect(Collectors.toList()), cart.getCustomerId(), cart.getOutlet(),
				cart.getDate());
		return cartDTO;
	};

	private static Function<ProductDTO, Product> toProduct = productDto -> {
		Product product = new Product(productDto.getId(), productDto.getName(), productDto.getDescription(), new BigDecimal(productDto.getUnitPrice()), productDto.getQuantity(),
				productDto.getProductId(), BigDecimal.valueOf(productDto.getBuyingPrice()), productDto.getDiscount());
		return product;
	};

	public static Function<CartDTO, Cart> toCart = (cartDto) -> {
		List<Product> products = cartDto.getProducts().stream().map(toProduct).collect(Collectors.toList());
		Cart cart = new Cart(cartDto.getId(), products, cartDto.getTotal(), cartDto.getCustomerId(), cartDto.getDate(), cartDto.getOutlet());
		cart.setTotal(getTotal(products).orElse(BigDecimal.ZERO));
		return cart;
	};

	public static Optional<BigDecimal> getTotal(List<Product> products) {
		Optional<BigDecimal> total = products.stream().map(product -> product.getUnitPrice().multiply(BigDecimal.valueOf(product.getQuantity()))).reduce((t, u) -> t.add(u));
		return total;
	}

}
