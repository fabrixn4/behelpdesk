package com.fabrizio.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabrizio.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDataChangeDesc(String ticketId);

}
