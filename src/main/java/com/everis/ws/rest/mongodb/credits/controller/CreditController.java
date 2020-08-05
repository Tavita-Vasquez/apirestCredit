package com.everis.ws.rest.mongodb.credits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ws.rest.mongodb.credits.model.Credit;
import com.everis.ws.rest.mongodb.credits.model.serviceImpl.CreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("/rest/credit")
@RestController
public class CreditController  {

	@Autowired
	private CreditService creditservice;
	

	
	@PostMapping("/save")
	public Mono<Credit> save(@RequestBody final Credit credit) {
	System.out.println("Will register the CREDIT :: "+ credit.toString());
	return creditservice.create(credit);
	}
	
	
	@GetMapping("/all")
	public Flux<Credit> getAll() {
	System.out.println("::GET_ALL CREDIT::");
	return creditservice.findAll();
	}
	
	
 	@PutMapping("/update/{id}")
	public Mono<Credit> updateById(@PathVariable("id") final String id, @RequestBody final Credit credit) {
	System.out.println("::Update the Credit record::");
	return creditservice.update(id, credit);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public Mono<Credit> delete(@PathVariable final String id) {
	System.out.println("::Will delete a Credit ::");
	return creditservice.delete(id);
	}
	
	
	@GetMapping("/findById/{id}")
	public Mono<Credit> findById(@PathVariable final String id) {
	System.out.println("::Will GetAllCreditById a Credit  ::");
	return creditservice.findById(id);
	}
	
	
	 
	
	
	
}
