package br.com.airlinecompany.util;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.airlinecompany.model.Airplane;
import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.model.FlightStatus;
import br.com.airlinecompany.model.Pilot;

public class FlightBuilder {

	private Flight flight;
	
	public static FlightBuilder create(){
		FlightBuilder flightBuilder = new FlightBuilder();
		flightBuilder.flight = new Flight();
		return flightBuilder;
	}
	
	public FlightBuilder start(LocalDateTime start){
		this.flight.setStart(start);
		return this;
	}
	
	public FlightBuilder end(LocalDateTime end){
		this.flight.setEnd(end);
		return this;
	}
	
	public FlightBuilder origin(String origin){
		this.flight.setOrigin(origin);
		return this;
	}
	
	public FlightBuilder destiny(String destiny){
		this.flight.setDestiny(destiny);
		return this;
	}
	
	public FlightBuilder airplane(Airplane airplane){
		this.flight.setAirplane(airplane);
		return this;
	}
	
	public FlightBuilder pilot(Pilot pilot){
		this.flight.setPilot(pilot);
		return this;
	}
	
	public FlightBuilder addStatus(FlightStatus flightStatus) {
		if (this.flight.getFlightStatus() == null)
			this.flight.setFlightStatus(new ArrayList<>());
		flightStatus.setFlight(this.flight);
		this.flight.getFlightStatus().add(flightStatus);
		return this;
	}
	
	public Flight build(){
		return this.flight;
	}
	
	
}
