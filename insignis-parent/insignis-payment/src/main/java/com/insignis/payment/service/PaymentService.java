package com.insignis.payment.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insignis.payment.model.Payment;
import com.insignis.payment.model.PaymentMethod;
import com.insignis.payment.repository.PaymentRepository;
import com.insignis.payment.service.ChargeRequest.Currency;
import com.insignis.shared.exception.NotFoundException;

@Service
public class PaymentService {

	private PaymentRepository paymentRepository;

	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public void savePayment(String chargeId, String balanceTransaction, String description, Integer amount, PaymentMethod card, String cartId, String status, Currency eur, Date date) {
		Payment payment = new Payment();
		payment.setChargeId(chargeId);
		payment.setBalanceTransactionId(balanceTransaction);
		payment.setDescription(description);
		payment.setAmount(BigDecimal.valueOf(amount));
		payment.setPaymentMethod(card);
		payment.setCartId(cartId);
		payment.setStatus(status);
		payment.setCurrency(eur);
		payment.setDate(date);

		this.paymentRepository.save(payment);
	}

	public Payment findById(String id) throws NotFoundException {
		return this.paymentRepository.findById(id).orElseThrow(() -> new NotFoundException("payment not found"));
	}

	public List<Payment> findAll() {
		return this.paymentRepository.findAll();
	}

	public Payment deletePayment(String id) throws NotFoundException {
		Payment payment = findById(id);
		this.paymentRepository.deleteById(id);
		return payment;
	}

}
