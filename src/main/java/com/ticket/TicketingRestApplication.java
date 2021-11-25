package com.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.ticket.rest"}
		)

public class TicketingRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingRestApplication.class, args);
	}

}
