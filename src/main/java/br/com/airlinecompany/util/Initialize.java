package br.com.airlinecompany.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import br.com.airlinecompany.enums.Status;
import br.com.airlinecompany.model.Airplane;
import br.com.airlinecompany.model.Flight;
import br.com.airlinecompany.model.FlightStatus;
import br.com.airlinecompany.model.Pilot;
import br.com.airlinecompany.repository.FlightRepository;

@Component
public class Initialize {

	public static void createAndSaveInitialData(ConfigurableApplicationContext context) {
		FlightRepository flightRepository = context.getBean(FlightRepository.class);
		List<Flight> flights = createFlights(createAirplanes(), createPilots());
		flightRepository.save(flights);
	}

	private static List<Pilot> createPilots() {
		List<Pilot> pilots = new ArrayList<>();
		pilots.add(new Pilot("Matheus Augusto de Carvalho Souza", LocalDate.of(1994, 2, 24)));
		pilots.add(new Pilot("Raquel Aparecida dos Santos", LocalDate.of(1994, 3, 27)));
		pilots.add(new Pilot("Paulo Gustavo de Carvalho Souza", LocalDate.of(1996, 7, 16)));
		return pilots;
	}

	private static List<Airplane> createAirplanes() {
		List<Airplane> airplanes = new ArrayList<>();
		airplanes.add(new Airplane("E195-E2", 144));
		airplanes.add(new Airplane("E175-E2", 90));
		airplanes.add(new Airplane("E190-E2", 114));
		return airplanes;
	}
	
	private static List<Flight> createFlights(List<Airplane> airplanes, List<Pilot> pilots) {
		List<Flight> flights = new ArrayList<>();
		flights.add(FlightBuilder.create()
			.start(LocalDateTime.of(2017, 8, 20, 10, 30))
			.end(LocalDateTime.of(2017, 8, 20, 13, 00))
			.origin("São José dos Campos - SP")
			.destiny("Fortaleza - CE")
			.airplane(airplanes.get(0))
			.pilot(pilots.get(0))
			.addStatus(new FlightStatus(Status.SCHEDULED, LocalDateTime.of(2017, 8, 20, 9, 30)))
			.addStatus(new FlightStatus(Status.TAKING_OFF, LocalDateTime.of(2017, 8, 20, 10, 30)))
			.addStatus(new FlightStatus(Status.FLYING, LocalDateTime.of(2017, 8, 20, 12, 00)))
			.build());
		
		flights.add(FlightBuilder.create()
			.start(LocalDateTime.of(2017, 8, 21, 20, 30))
			.end(LocalDateTime.of(2017, 8, 21, 23, 00))
			.origin("São José dos Campos - SP")
			.destiny("Curitiba - PR")
			.airplane(airplanes.get(1))
			.pilot(pilots.get(1))
			.addStatus(new FlightStatus(Status.SCHEDULED, LocalDateTime.of(2017, 8, 21, 19, 00)))
			.build());
		
		flights.add(FlightBuilder.create()
			.start(LocalDateTime.of(2017, 8, 22, 8, 30))
			.end(LocalDateTime.of(2017, 8, 22, 12, 00))
			.origin("São José dos Campos - SP")
			.destiny("Gramado - RS")
			.airplane(airplanes.get(2))
			.pilot(pilots.get(2))
			.addStatus(new FlightStatus(Status.SCHEDULED, LocalDateTime.of(2017, 8, 22, 7, 30)))
			.addStatus(new FlightStatus(Status.TAKING_OFF, LocalDateTime.of(2017, 8, 22, 8, 30)))
			.addStatus(new FlightStatus(Status.FLYING, LocalDateTime.of(2017, 8, 22, 10, 00)))
			.addStatus(new FlightStatus(Status.LANDED, LocalDateTime.of(2017, 8, 22, 12, 00)))
			.build());
		return flights;
	}
	
}
