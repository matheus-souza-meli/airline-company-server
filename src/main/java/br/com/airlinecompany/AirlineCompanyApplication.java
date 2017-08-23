package br.com.airlinecompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.airlinecompany.util.Initialize;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class AirlineCompanyApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AirlineCompanyApplication.class, args);
		createAndSaveInitialData(context);
	}

	private static void createAndSaveInitialData(ConfigurableApplicationContext context) {
		Initialize.createAndSaveInitialData(context);
	}

}
