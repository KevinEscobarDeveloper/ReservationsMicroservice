package com.aleal.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.config.ReservationsServiceConfiguration;
import com.aleal.reservations.model.PropertisReservations;

import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ReservationController {
	
	@Autowired
	private IReservationService service;

	@Autowired
	private ReservationsServiceConfiguration cofigReservations;
	
	

	@GetMapping("reservations")
	public List<Reservation> search(){
		log.info("Inicio del metodo search en reservations");
		return (List<Reservation>) this.service.search();	
	}
	
	@GetMapping("/reservations/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertisReservations proReservations = new PropertisReservations(cofigReservations.getMsg(), cofigReservations.getBuildVersion(), cofigReservations.getMailDetails());
		String jsonString = owj.writeValueAsString(proReservations);
		return jsonString;
	}

}
