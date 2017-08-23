package br.com.airlinecompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.airlinecompany.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long>{

}
