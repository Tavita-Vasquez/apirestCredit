package com.everis.ws.rest.mongodb.credits.model.serviceImpl;
 

import org.springframework.stereotype.Service;

import com.everis.ws.rest.mongodb.credits.model.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ICredit {
	 Mono<Credit> create(Credit credit);
	 Flux<Credit> findAll();
	 Mono<Credit> update(String id, Credit credit);
	 Mono<Credit> getById(String id);
	 Mono delete(String id);
	

}
