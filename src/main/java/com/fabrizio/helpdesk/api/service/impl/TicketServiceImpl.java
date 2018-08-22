package com.fabrizio.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fabrizio.helpdesk.api.entity.ChangeStatus;
import com.fabrizio.helpdesk.api.entity.Ticket;
import com.fabrizio.helpdesk.api.repository.ChangeStatusRepository;
import com.fabrizio.helpdesk.api.repository.TicketRepository;
import com.fabrizio.helpdesk.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	ChangeStatusRepository changeStatusRepository;

	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		return this.ticketRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		this.ticketRepository.delete(id);
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findAll(pageable);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return this.changeStatusRepository.findByTicketIdOrderByDataChangeDesc(ticketId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pageable, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pageable);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(title, status, priority, userId, pageable);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findByNumber(number, pageable);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParameterAndAssigned(int page, int count, String title, String status, String priority,
			String assignedUser) {
		Pageable pageable = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(title, status, priority, assignedUser, pageable);
	}

	
}
