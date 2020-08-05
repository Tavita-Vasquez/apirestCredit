package com.everis.ws.rest.mongodb.credits.model.repository;
 
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.ws.rest.mongodb.credits.model.Credit;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String>{
	 // List<BankAccount> findByAccountType(Long idAccountType);
	  
}
