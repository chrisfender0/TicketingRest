package com.ticket.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ticket.pojo.Ticket;

@Service
public class TicketService {
	
	/**
	 * Convert json string to gson then to Ticket
	 * 
	 * Example data: 
	 * {"subject":"Test Subject","note":"Test note. It seems to be working!","priority":"High","dateCreated":"2021-11-25T01:55:09.620Z"}
	 * 
	 * @param String json
	 * @return Ticket
	 */
	public static Ticket convertToTicketObject(String json){
		Gson g = new Gson();
		Ticket ticket = new Ticket();
		ticket = g.fromJson(json, Ticket.class);
		return ticket;
	}
	
	public static String convertToId(String json) {
		Gson g = new Gson();
		Ticket ticket = new Ticket();
		ticket = g.fromJson(json, Ticket.class);
		return ticket.getId();
	}

}
