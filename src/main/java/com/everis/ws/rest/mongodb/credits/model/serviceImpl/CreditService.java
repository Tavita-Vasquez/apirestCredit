package com.everis.ws.rest.mongodb.credits.model.serviceImpl;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.everis.ws.rest.mongodb.credits.model.Credit;
import com.everis.ws.rest.mongodb.credits.model.repository.CreditRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {
	
	@Autowired
	private CreditRepository repository;

	 @Autowired
	 MessageSource i18n;
	 
	//log
		private static final Logger log=(Logger) LogManager.getLogger(CreditService.class);

		
	 
	public Mono<Credit> create(Credit credit) {
		// TODO Auto-generated method stub
		//return template.save(availableBalance);
		log.info("Begin service save of bank Account.");
		Mono<Credit> saved = null;
		 
		try {
			 
				saved = repository.save(credit);
				log.info("Save Correct Transaction..");
			 
		}catch(Exception e) {
			log.error("Error when saving Credit in data base.");
			
		}
		return saved;
		
		
	
	}

	public Flux<Credit> findAll() {
		// TODO Auto-generated method stub
		//return template.findAll(AvailableBalance.class);
		log.info("Begin service List All of bank Account.");
		 return repository.findAll();
		/*
		 * Flux<BankAccount> list = null; try {
		 * 
		 * list = repository.findAll();
		 * log.info("Get All List Bank Account Correct Transaction..");
		 * 
		 * }catch(Exception e) {
		 * log.error("Error when call method find All Bank Account in data.");
		 * 
		 * }
		 * 
		 *
		 */
	}

	/*
	 * @Override public Mono<AvailableBalance> update(String id) { // TODO
	 * Auto-generated method stub return template.update(AvailableBalance.class); }
	 */
	
	public  Mono<Credit> update(final String id,Credit credit) {
		log.info("Begin Service Update Data Bank Account " + id + credit.getTitular() );
		Mono<Credit> updateData = null;
	try {
		updateData = repository.save(credit);
		log.info(" Update Data Credit for Client by Id " + id);
		
	} catch (Exception e) {
		log.error("Error when call method Service update Credit in data.");
	}
		
		
		
		return updateData;
}
	

	 @SuppressWarnings("rawtypes")
	public Mono delete(final String id) {
		 log.info("Begin Service Delete Data from Bank Account" + id);
		 Mono delete=null;
		 try {
			 final Mono<Credit> dbBankAccount = getById(id);
			  if (Objects.isNull(dbBankAccount)) {
			   return Mono.empty();
			  }
			  delete =  getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(BankAccountoBeDeleted -> repository
			    .delete(BankAccountoBeDeleted).then(Mono.just(BankAccountoBeDeleted)));
			 
			  log.info(" Delete Data Credit for Client by Id " + id);
				
			} catch (Exception e) {
				log.error("Error when call method Service Delete Credit in data.");
			}
		return delete;
		 
		  
		 }
		

	public Mono<Credit> getById(final String id) {
		 log.info("Begin Service get by Id Data from Credit" + id);
		 Mono<Credit> findById = null;
		 try {
			 	findById = repository.findById(id);
			  log.info(" Find Bank Account  by Id  " + id);
				
			} catch (Exception e) {
				log.error("Error when call method Service get All By Id data.");
			}
		 
	  return  findById;
	 }

	public Mono<Credit> findById(String id) {
		// TODO Auto-generated method stub
		 log.info("Begin Service Find by Id Data from Credit" + id);
		return repository.findById(id);
	}

}
