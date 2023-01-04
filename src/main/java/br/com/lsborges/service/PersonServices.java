package br.com.lsborges.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lsborges.model.Person;
import br.com.lsborges.model.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person createService(Person person) {	
		personRepository.save(person);
		return person;
	}
	
	public ResponseEntity<Person> uptadeService(long id, Person personReceived){
		Optional<Person> personExistis = personRepository.findById(id);
		
		if(!personExistis.isPresent()) {
			Person newPerson = personExistis.get();
			newPerson.setName(personReceived.getName());
			newPerson.setBirthDate(personReceived.getBirthDate());
			newPerson.setCep(personReceived.getCep());
			newPerson.setCity(personReceived.getCity());
			newPerson.setLogradouro(personReceived.getLogradouro());
			newPerson.setNumber(personReceived.getNumber());
			return new ResponseEntity<Person>(personRepository.save(newPerson), HttpStatus.OK);
			}else {
				return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
			}
		
	}
	
	public Optional<Person> findByIdService(Long id) throws Exception {
		return personRepository.findById(id);
		}
	

	public List<Person> findAllService(){
		return personRepository.findAll();
	}

	

}
