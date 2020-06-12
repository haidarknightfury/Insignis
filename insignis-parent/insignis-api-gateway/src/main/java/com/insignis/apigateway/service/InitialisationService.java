package com.insignis.apigateway.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.insignis.apigateway.model.Role;
import com.insignis.apigateway.model.RoleEnum;
import com.insignis.apigateway.repository.RoleRepository;

@Component
public class InitialisationService implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Value("${insignis.app.generateRoles}")
	private Boolean generateRoles;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("generate roles in db : " + generateRoles);
		if (generateRoles) {
			roleRepository.deleteAll();
			Arrays.asList(RoleEnum.values()).stream().forEach(role -> {
				roleRepository.save(new Role(role));
			});
		}

	}

}
