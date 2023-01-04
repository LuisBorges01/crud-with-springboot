package br.com.lsborges.model;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	
	@Autowired
	PersonRepository personRepository;
	
	public Person createService(Person person) {	
		personRepository.save(person);
		return person;
	}
	
	public Person uptadeService(Person person){
		logger.info("Uptading People!");
		personRepository.save(person);
		return person;
		
	}
	
	public Optional<Person> findByIdService(Long id) throws Exception {
		logger.info("Finding one person!");
		Optional<Person> find = personRepository.findById(id);
		return find;
	}
	

	public List<Person> findAllService(){
		logger.info("Finding all people!");
		return personRepository.findAll();
	}

	

}
