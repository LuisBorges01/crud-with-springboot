package br.com.lsborges.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id")
	private Person person;
		
	@Id
	private Long id;
	@Column(name = "cep")
	private String cep;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "city")
	private String city;
	@Column(name = "number")
	private String number;
	
		
	
	public Endereco(String cep, String logradouro, String city, String number) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.city = city;
		this.number = number;
	}

	
	public Endereco(List<Endereco> endereco) {}


	public String getCep() {
		return cep;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

}
