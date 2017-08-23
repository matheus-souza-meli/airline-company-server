package br.com.airlinecompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.airlinecompany.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

}
