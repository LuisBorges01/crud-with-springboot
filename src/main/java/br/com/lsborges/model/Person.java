package br.com.lsborges.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Person implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private static List<Endereco> endereco;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*          -          */
	@Column(name = "name")
	private String name;
	@Column(name = "birthDate")
	private String birthDate;

	

	public Person() {}
	
	public Person(Long id, String name, String birthDate, List<Endereco> endereco) {
		this.endereco = endereco;
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
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

	public static List<Endereco> getEndereço() {
		return endereco;
	}
	public void setEndereço(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
