package br.com.airlinecompany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Airplane {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String model;
	
	@NotNull
	private Integer capacity;
	
	Airplane() {
	}

	public Airplane(String model, Integer capacity) {
		this.model = model;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}
