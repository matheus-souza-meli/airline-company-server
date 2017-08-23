package br.com.airlinecompany.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import br.com.airlinecompany.enums.Status;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private LocalDateTime start;
	
	@NotNull
	private LocalDateTime end;
	
	@NotNull
	private String origin;
	
	@NotNull
	private String destiny;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="airplane_id")
	@NotNull
	private Airplane airplane;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="pilot_id")
	@NotNull
	private Pilot pilot;
	
	@OneToMany(mappedBy="flight", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<FlightStatus> flightStatus;
	
	public Flight() {
		this.flightStatus = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<FlightStatus> getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(List<FlightStatus> flightStatus) {
		this.flightStatus = flightStatus;
	}

}
