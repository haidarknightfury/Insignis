package com.insignis.payment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.payment.mapper.MapperUtils;
import com.insignis.payment.model.Payment;
import com.insignis.payment.service.PaymentService;
import com.insignis.shared.dto.PaymentDTO;
import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController implements BaseResources {

	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PaymentDTO findById(@Param("id") String id) throws NotFoundException {
		PaymentDTO paymentDTO = MapperUtils.toPaymentDTO().apply(paymentService.findById(id));
		return paymentDTO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaymentDTO> findAllPayments() {
		List<PaymentDTO> payments = paymentService.findAll().stream().map(MapperUtils.toPaymentDTO()).collect(Collectors.toList());
		return payments;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PaymentDTO createCashPayment(@RequestBody PaymentDTO paymentDTO) {
		return paymentDTO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PaymentDTO deletePayment(@RequestParam String id) throws NotFoundException {
		Payment payment = paymentService.deletePayment(id);
		return MapperUtils.toPaymentDTO().apply(payment);
	}

}
