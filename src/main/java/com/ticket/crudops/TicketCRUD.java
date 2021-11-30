package com.ticket.crudops;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
	
	public static Map<String, String> saveNewTicket(String json, TicketRepository ticketRepository) {
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticket.setDateCreated(new Date());
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.RESPONSE_SAVE_TICKET);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.ERROR_SAVING_TICKET);
	}
	
	public static Ticket getTicketWithId(String id, TicketRepository ticketRepository) {
		Optional<Ticket> optionalTicket =  ticketRepository.findById(TicketService.convertToId(id));
		Ticket ticket = optionalTicket.get();
		return ticket;
	}
	
	public static Map<String, String> updateTicket(String json, TicketRepository ticketRepository) {
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.RESPONSE_UPDATE_TICKET);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.ERROR_UPDATING_TICKET);
	}
	
	public static Map<String, String> resolveTicket(String json, TicketRepository ticketRepository){
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticket.setStatus(TicketConstants.STATUS_RESOLVED);
			ticket.setDateModified(new Date());
			ticketRepository.save(ticket);
			return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.RESPONSE_RESOLVE_TICKET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.ERROR_RESOLVING_TICKET);
	}
	
	public static Map<String, String> deleteTicket(String json, TicketRepository ticketRepository){
		try {
			Ticket ticket = TicketService.convertToTicketObject(json);
			ticketRepository.delete(ticket);
			return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.RESPONSE_DELETE_TICKET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.singletonMap(TicketConstants.RESPONSE, TicketConstants.ERROR_DELETING_TICKET);
	}
	
}
