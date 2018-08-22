package com.fabrizio.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabrizio.helpdesk.api.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
}
