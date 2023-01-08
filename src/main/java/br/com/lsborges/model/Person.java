package br.com.lsborges.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthDate;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> address;

	public Person(Long id, String name, String birthDate, List<Address> address) {
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}

    
}
