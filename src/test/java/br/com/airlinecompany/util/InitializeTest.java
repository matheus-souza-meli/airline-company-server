package br.com.airlinecompany.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.airlinecompany.enums.Status;
import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.repository.FlightRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DataJpaTest
public class InitializeTest {

	@Autowired
	private ConfigurableApplicationContext context;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Test
	public void shouldCreateAndSavePilot() {
		Initialize.createAndSaveInitialData(context);
		
		List<Flight> flights = flightRepository.findAll();
		assertThat(flights.size()).isEqualTo(3);
		assertThat(flights.get(0).getId()).isGreaterThan(0L);
		assertThat(flights.get(0).getAirplane()).isNotNull();
		assertThat(flights.get(0).getAirplane().getModel()).isEqualTo("E195-E2");
		assertThat(flights.get(0).getPilot()).isNotNull();
		assertThat(flights.get(0).getPilot().getName()).isEqualTo("Matheus Augusto de Carvalho Souza");
		assertThat(flights.get(0).getFlightStatus()).isNotNull();
		assertThat(flights.get(0).getFlightStatus().size()).isEqualTo(3);
		assertThat(flights.get(0).getFlightStatus().get(0).getFlight().getId()).isEqualTo(flights.get(0).getId());
		assertThat(flights.get(0).getFlightStatus().get(0).getStatus()).isEqualTo(Status.SCHEDULED);
		assertThat(flights.get(0).getFlightStatus().get(1).getStatus()).isEqualTo(Status.TAKING_OFF);
		assertThat(flights.get(0).getFlightStatus().get(2).getStatus()).isEqualTo(Status.FLYING);
	}
	
}
