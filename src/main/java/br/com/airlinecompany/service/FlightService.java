package br.com.airlinecompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> fetch() {
		return flightRepository.findAll();
	}

}
