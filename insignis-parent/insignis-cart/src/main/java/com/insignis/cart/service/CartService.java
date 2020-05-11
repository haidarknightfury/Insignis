package com.insignis.cart.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.EntryProcessor;
import com.insignis.cart.model.Cart;

@Service
public class CartService implements MapNames {

	private HazelcastInstance hazelcastInstance;
	private IMap<String, Cart> cartMap;

	@Autowired
	public CartService(@Qualifier("ClientInstance") HazelcastInstance hazelcastInstance) {
		this.hazelcastInstance = hazelcastInstance;
	}

	@PostConstruct
	public void init() {
		this.cartMap = this.hazelcastInstance.getMap(CART_MAP);
	}

	public Cart getCart(String key) {
		return this.cartMap.get(key);
	}

	public void addCart(Cart cart) {
		this.cartMap.put(cart.getId(), cart);
	}

	public void addCarts(Collection<Cart> carts) {
		Map<String, Cart> cartLocalMap = new HashMap<>();
		for (Cart cart : carts) {
			cartLocalMap.put(cart.getId(), cart);
		}
		this.cartMap.putAll(cartLocalMap);
	}

	public void deleteCart(Cart cart) {
		this.cartMap.delete(cart.getId());
	}

	@SuppressWarnings("unchecked")
	public <T> T updateCart(String cartId, EntryProcessor<String, Cart> ep) {
		return (T) this.cartMap.executeOnKey(cartId, ep);
	}

	public List<Cart> findAll() {
		return this.cartMap.entrySet().stream().map((entry) -> entry.getValue()).collect(Collectors.toList());
	}

}
