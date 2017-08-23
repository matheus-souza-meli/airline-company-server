package br.com.airlinecompany.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.airlinecompany.model.Airplane;

@RunWith(SpringRunner.class)
@DataJpaTest	
public class AirplaneRepositoryTest {

	@Autowired
    private AirplaneRepository airplaneRepository;
	
	@Test
	public void shouldReturnAllAirplanes() {
		this.airplaneRepository.save(new Airplane("E195-E2", 144));

		List<Airplane> airplanes = this.airplaneRepository.findAll();
		assertThat(airplanes.size()).isEqualTo(1);
		assertThat(airplanes.get(0).getId()).isGreaterThan(0L);
		assertThat(airplanes.get(0).getModel()).isEqualTo("E195-E2");
		assertThat(airplanes.get(0).getCapacity()).isEqualTo(144);
	}

}
