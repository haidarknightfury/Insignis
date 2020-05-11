package com.insignis.cart.service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.MapStore;
import com.insignis.cart.model.Cart;
import com.insignis.cart.repository.CartRepository;

@Service
public class CartMapStore implements MapStore<String, Cart>, MapNames {

	private CartRepository cartRepository;

	@Autowired
	public CartMapStore(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public void store(String key, Cart value) {
		System.out.println("saving cart with key " + key);
		this.cartRepository.save(value);
	}

	@Override
	public void storeAll(Map<String, Cart> map) {
		this.cartRepository.saveAll(map.values());
	}

	@Override
	public void delete(String key) {
		Cart cart = this.load(key);
		this.cartRepository.delete(cart);
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		Iterable<Cart> carts = this.cartRepository.findAllById(keys);
		this.cartRepository.deleteAll(carts);
	}

	@Override
	public Cart load(String key) {
		System.out.println("loading cart with key " + key);
		return this.cartRepository.findById(key).orElse(null);
	}

	@Override
	public Map<String, Cart> loadAll(Collection<String> keys) {
		Iterable<Cart> carts = this.cartRepository.findAllById(keys);
		return StreamSupport.stream(carts.spliterator(), false).collect(Collectors.toMap(Cart::getId, Function.identity()));
	}

	@Override
	public Iterable<String> loadAllKeys() {
		Iterable<Cart> carts = this.cartRepository.findAll();
		return StreamSupport.stream(carts.spliterator(), false).map(Cart::getId).collect(Collectors.toList());
	}

}
