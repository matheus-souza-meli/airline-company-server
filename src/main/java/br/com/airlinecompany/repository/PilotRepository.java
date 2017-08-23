package br.com.airlinecompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.airlinecompany.model.Pilot;

public interface PilotRepository extends JpaRepository<Pilot, Long>{

}
