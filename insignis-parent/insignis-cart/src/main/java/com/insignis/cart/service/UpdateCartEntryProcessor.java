package com.insignis.cart.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import com.hazelcast.map.EntryBackupProcessor;
import com.hazelcast.map.EntryProcessor;
import com.insignis.cart.model.Cart;
import com.insignis.cart.model.Product;

public class UpdateCartEntryProcessor implements Serializable, EntryProcessor<String, Cart>, EntryBackupProcessor<String, Cart> {

	private static final long serialVersionUID = -636426675249414132L;

	private List<Product> products;

	public UpdateCartEntryProcessor(List<Product> products) {
		this.products = products;
	}

	@Override
	public Object process(Entry<String, Cart> entry) {
		Cart cart = entry.getValue();
		cart.setProducts(this.products);
		Optional<BigDecimal> total = this.products.stream().map(product -> product.getUnitPrice().multiply(BigDecimal.valueOf(product.getQuantity()))).reduce((t, u) -> t.add(u));
		cart.setTotal(total.orElse(BigDecimal.ZERO));
		return cart;
	}

	@Override
	public EntryBackupProcessor<String, Cart> getBackupProcessor() {
		return this;
	}

	@Override
	public void processBackup(Entry<String, Cart> entry) {
		this.process(entry);
	}

}
