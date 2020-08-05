package com.everis.ws.rest.mongodb.credits.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Data
@AllArgsConstructor
@NoArgsConstructor  
@Getter
@Setter
public class CreditDTO {
	private String id;
	private String headline;//titular
	private String credittype;//personal, empresarial, tarjetas de crédito y adelanto de efectivo).
	private Double baseline; //sin comissiones
	private Double availablebalance; //saldo disponible.
	private Double consume;
	private LocalDate datecredit;
	private String bank;
	private Double commision;
}
