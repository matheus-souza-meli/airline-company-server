package br.com.airlinecompany.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.airlinecompany.model.Pilot;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PilotRepositoryTest {

	@Autowired
    private PilotRepository pilotRepository;
	
	@Test
	public void shouldReturnAllPilots() {
		this.pilotRepository.save(new Pilot("Matheus Augusto", LocalDate.of(1994, 02, 24)));

		List<Pilot> pilots = this.pilotRepository.findAll();
		assertThat(pilots.size()).isEqualTo(1);
		assertThat(pilots.get(0).getId()).isGreaterThan(0L);
		assertThat(pilots.get(0).getName()).isEqualTo("Matheus Augusto");
		assertThat(pilots.get(0).getBirthday()).isEqualTo(LocalDate.of(1994, 02, 24));
	}

}
