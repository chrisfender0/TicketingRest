package com.ticket.crudops;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ticket.constants.TicketConstants;
import com.ticket.pojo.Ticket;
import com.ticket.repository.TicketRepository;
import com.ticket.service.TicketService;

@Service
public class TicketCRUD {
	
	public static List<Ticket> getAllTickets(TicketRepository ticketRepository){
		return ticketRepository.findAll();
	}
	
	public static String saveNewTicket(String json, TicketRepository ticketRepository) {
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticket.setDateCreated(new Date());
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return "Saved successfully";
		} catch(Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	
	public static Ticket getTicketWithId(String id, TicketRepository ticketRepository) {
		Optional<Ticket> optionalTicket =  ticketRepository.findById(TicketService.convertToId(id));
		Ticket ticket = optionalTicket.get();
		System.out.println(ticket.getSubject());
		return ticket;
	}
	
	public static String updateTicket(String json, TicketRepository ticketRepository) {
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return "Ticket updated successfully";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return TicketConstants.ERROR_UPDATING_TICKET;
	}
	
	public static String resolveTicket(String id, TicketRepository ticketRepository){
		try {
			Ticket ticket = getTicketWithId(id, ticketRepository);
			ticket.setStatus(TicketConstants.STATUS_RESOLVED);
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return "Ticket resolved successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TicketConstants.ERROR_RESOLVING_TICKET;
	}
}
