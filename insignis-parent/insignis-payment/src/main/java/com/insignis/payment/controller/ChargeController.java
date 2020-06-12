package com.insignis.payment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.insignis.payment.model.PaymentMethod;
import com.insignis.payment.service.ChargeRequest;
import com.insignis.payment.service.ChargeRequest.Currency;
import com.insignis.payment.service.PaymentService;
import com.insignis.payment.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class ChargeController {

	private static final String DESCRIPTION = "Your transaction has been executed. Please find the status";
	private StripeService stripePaymentService;
	private PaymentService paymentService;

	@Autowired
	public ChargeController(StripeService stripePaymentService, com.insignis.payment.service.PaymentService paymentService) {
		this.stripePaymentService = stripePaymentService;
		this.paymentService = paymentService;
	}

	@PostMapping("/charge")
	public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
		chargeRequest.setDescription(DESCRIPTION);
		chargeRequest.setCurrency(Currency.EUR);
		Charge charge = stripePaymentService.charge(chargeRequest);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		model.addAttribute("chargeId", charge.getId());
		model.addAttribute("balance_transaction", charge.getBalanceTransaction());

		this.paymentService.savePayment(charge.getId(), charge.getBalanceTransaction(), DESCRIPTION, chargeRequest.getAmount(), PaymentMethod.CARD, chargeRequest.getCartId(), charge.getStatus(),
				Currency.EUR, new Date());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}
}