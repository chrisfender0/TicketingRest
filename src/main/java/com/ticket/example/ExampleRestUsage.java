package com.ticket.example;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ticket.pojo.Ticket;
import com.ticket.repository.TicketRepository;

@Service
public class ExampleRestUsage {
	
	/**
	 * Creating a ticket
	 */
	public static String createTicket(TicketRepository ticketRepository) {
		ticketRepository.insert(makeTicketObjectWIthData());
		return "Example Ticket Created";
	}
	
	/**
	 * Handy Create Ticket
	 */
	public static Ticket makeTicketObjectWIthData() {
		Ticket t = new Ticket();
		t.setSubject("Test Subject");
		t.setNote("Test note. It seems to be working!");
		t.setPriority("High");
		t.setDateCreated(new Date());
		return t;
	}

}
