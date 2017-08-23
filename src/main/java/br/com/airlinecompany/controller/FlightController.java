package br.com.airlinecompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.service.FlightService;

@RestController
public class FlightController {

	private FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@CrossOrigin
	@RequestMapping("/flights")
	public @ResponseBody List<Flight> flights(){
		return flightService.fetch();
	}
	
}
