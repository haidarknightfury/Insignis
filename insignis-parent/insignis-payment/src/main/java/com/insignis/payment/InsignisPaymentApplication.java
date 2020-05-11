package com.insignis.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.insignis.shared.config.SharedConfig;

@SpringBootApplication
@Import(SharedConfig.class)
public class InsignisPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsignisPaymentApplication.class, args);
	}

}
