package com.fabrizio.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabrizio.helpdesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String>{

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId); 
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String priority, Pageable page);
		
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String priority, String userId, Pageable page);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
			String title, String status, String priority, String userId, Pageable page);	
	
	Page<Ticket> findByNumber(Integer number, Pageable page);
}
