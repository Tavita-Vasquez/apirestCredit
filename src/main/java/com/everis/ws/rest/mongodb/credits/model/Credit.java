package com.everis.ws.rest.mongodb.credits.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Credit {

	@Id
	private String id; 
	
	private String prodtype; 
	private String titular;
	private Double amount;
	 
	private String credittypedesc;
	private String credittype;
	private Double consume;
	
	
}
