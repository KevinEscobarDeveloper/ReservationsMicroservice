package com.aleal.reservations.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PropertisReservations {
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
}
