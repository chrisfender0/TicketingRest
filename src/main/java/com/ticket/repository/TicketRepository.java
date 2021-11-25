package com.ticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ticket.pojo.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{

}
