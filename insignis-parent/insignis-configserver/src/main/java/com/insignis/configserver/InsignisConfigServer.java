package com.insignis.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InsignisConfigServer {

	public static void main(String[] arguments) {
		SpringApplication.run(InsignisConfigServer.class, arguments);
	}
}
