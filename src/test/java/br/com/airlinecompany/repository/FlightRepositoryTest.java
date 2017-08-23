package br.com.airlinecompany.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.airlinecompany.model.Airplane;
import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.model.Pilot;
import br.com.airlinecompany.util.FlightBuilder;

@RunWith(SpringRunner.class)
@DataJpaTest	
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private PilotRepository pilotRepository;
    
    @Autowired
    private AirplaneRepository airplaneRepository;
	
	@Test
	public void shouldReturnAllFlights() {
		Flight flight = createFlight();
		this.flightRepository.save(flight);

		List<Flight> flights = this.flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(1);
		assertThat(flights.get(0).getId()).isGreaterThan(0L);
		assertThat(flights.get(0).getStart()).isEqualTo(LocalDateTime.of(2017, 8, 21, 06, 00));
		assertThat(flights.get(0).getEnd()).isEqualTo(LocalDateTime.of(2017, 8, 21, 10, 00));
		assertThat(flights.get(0).getOrigin()).isEqualTo("São José dos Campos - SP");
		assertThat(flights.get(0).getDestiny()).isEqualTo("Fortaleza - CE");
		assertThat(flights.get(0).getAirplane()).isNotNull();
		assertThat(flights.get(0).getAirplane().getModel()).isEqualTo("E195-E2");
		assertThat(flights.get(0).getPilot()).isNotNull();
		assertThat(flights.get(0).getPilot().getName()).isEqualTo("Matheus Augusto");
		
		flightRepository.delete(flight);
		List<Pilot> pilots = pilotRepository.findAll();
		assertThat(pilots.size()).isEqualTo(1);
	}
	
	@Test
	public void shouldDeleteFlightButNotDeletePilot(){
		Flight flight = createFlight();
		flightRepository.save(flight);
		
		List<Flight> flights = flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(1);
		
		flightRepository.delete(flight);
		flights = flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(0);
		
		List<Pilot> pilots = pilotRepository.findAll();
		assertThat(pilots.size()).isEqualTo(1);
		assertThat(pilots.get(0).getName()).isEqualTo("Matheus Augusto");
	}
	
	@Test
	public void shouldDeleteFlightButNotDeleteAirplane(){
		Flight flight = createFlight();
		flightRepository.save(flight);
		
		List<Flight> flights = flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(1);
		
		flightRepository.delete(flight);
		flights = flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(0);
		
		List<Airplane> airplanes = airplaneRepository.findAll();
		assertThat(airplanes.size()).isEqualTo(1);
		assertThat(airplanes.get(0).getModel()).isEqualTo("E195-E2");
	}
	
	private Flight createFlight(){
		Airplane airplane = new Airplane("E195-E2", 144);
		Pilot pilot = new Pilot("Matheus Augusto", LocalDate.of(1994, 2, 24));
		return FlightBuilder.create()
				.start(LocalDateTime.of(2017, 8, 21, 06, 00))
				.end(LocalDateTime.of(2017, 8, 21, 10, 00))
				.origin("São José dos Campos - SP")
				.destiny("Fortaleza - CE")
				.airplane(airplane)
				.pilot(pilot)
				.build();
	}

}
