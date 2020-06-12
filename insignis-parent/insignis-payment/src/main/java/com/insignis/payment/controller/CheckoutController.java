package com.insignis.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.insignis.payment.service.CartClientService;
import com.insignis.payment.service.ChargeRequest;
import com.insignis.shared.dto.CartDTO;

@Controller
public class CheckoutController {

	private String stripePublicKey;
	private CartClientService cartClientService;

	@Autowired
	public CheckoutController(@Value("${STRIPE_PUBLIC_KEY}") String stripePublicKey, CartClientService cartClientService) {
		this.stripePublicKey = stripePublicKey;
		this.cartClientService = cartClientService;
	}

	@GetMapping("/checkout/{cartId}")
	public String checkout(@PathVariable(value = "cartId", required = false) String cartId, Model model) {
		System.out.println(cartId);
		CartDTO cartDTO = cartClientService.getCart(cartId);
		model.addAttribute("amount", cartDTO.getTotal().intValue()); // in cents
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("products", cartDTO.getProducts());
		model.addAttribute("currency", ChargeRequest.Currency.EUR);
		model.addAttribute("cartId", cartId);
		return "checkout";
	}
}