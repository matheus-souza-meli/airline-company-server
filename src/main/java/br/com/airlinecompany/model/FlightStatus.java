package br.com.airlinecompany.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.airlinecompany.enums.Status;

@Entity
public class FlightStatus {

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime time;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	@JsonIgnore
	private Flight flight;

	FlightStatus() {
	}
	
	public FlightStatus(Status status, LocalDateTime time) {
		this.status = status;
		this.time = time;
	}

	public FlightStatus(Status status, LocalDateTime time, Flight flight) {
		this.status = status;
		this.time = time;
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
