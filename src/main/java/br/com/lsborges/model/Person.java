package br.com.lsborges.model;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "name")
	private String name;
	@Column(name = "birthDate")
	private String birthDate;

	
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "cep")
	private String cep;
	@Column(name = "city")
	private String city;
	@Column(name = "number")
	private int number;
	
	public Person() {}
	
	public Person(String name, String birthDate, String logradouro, String cep, String city, int number) {
		this.name = name;
		this.birthDate = birthDate;
		this.logradouro = logradouro;
		this.cep = cep;
		this.city = city;
		this.number = number;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
}
