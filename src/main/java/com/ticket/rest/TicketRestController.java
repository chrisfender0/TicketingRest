package com.ticket.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.crudops.TicketCRUD;
import com.ticket.pojo.Ticket;
import com.ticket.repository.TicketRepository;

@RestController
@RequestMapping(value="/ticket")
public class TicketRestController {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@RequestMapping(value="/getAllTickets")
	public List<Ticket> getAllTickets(){
		return TicketCRUD.getAllTickets(ticketRepository);
	}
	
	@RequestMapping(value="/createTicket")
	public String createTicket(@RequestBody String json) {
		return TicketCRUD.saveNewTicket(json, ticketRepository);
	}
	
	@RequestMapping(value="/updateTicket")
	public String updateTicket(@RequestBody String json) {
		return TicketCRUD.updateTicket(json, ticketRepository);
	}
	
	@RequestMapping(value="/getTicketWithId")
	public Ticket getTicketWithId(@RequestBody String id) {
		return TicketCRUD.getTicketWithId(id, ticketRepository);
	}
	
	@RequestMapping(value="/resolveTicket")
	public String resolveTicket(@RequestBody String id) {
		return TicketCRUD.resolveTicket(id, ticketRepository);
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "welcome to the TicketRestController index";
	}
	

}
