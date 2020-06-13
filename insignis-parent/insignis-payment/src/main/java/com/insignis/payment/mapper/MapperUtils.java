package com.insignis.payment.mapper;

import java.util.function.Function;

import com.insignis.payment.model.Payment;
import com.insignis.shared.dto.PaymentDTO;

public class MapperUtils {

	public static Function<Payment, PaymentDTO> toPaymentDTO() {
		return payment -> {
			PaymentDTO paymentDTO = new PaymentDTO();
			paymentDTO.setId(payment.getId());
			paymentDTO.setChargeId(payment.getChargeId());
			paymentDTO.setBalanceTransactionId(payment.getBalanceTransactionId());
			paymentDTO.setDescription(payment.getDescription());
			paymentDTO.setAmount(payment.getAmount());
			paymentDTO.setPaymentMethod(payment.getPaymentMethod() != null ? payment.getPaymentMethod().name() : null);
			paymentDTO.setCartId(payment.getCartId());
			paymentDTO.setStatus(payment.getStatus());
			paymentDTO.setCurrency(payment.getCurrency() != null ? payment.getCurrency().name() : null);
			paymentDTO.setDate(payment.getDate());
			return paymentDTO;
		};
	}

}
