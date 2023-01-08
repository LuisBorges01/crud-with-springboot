package br.com.lsborges.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lsborges.execption.PersonExcpetion;
import br.com.lsborges.model.Person;
import br.com.lsborges.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
	
	@Autowired
    private PersonRepository repository;

    public Person add(Person person) {
    	return repository.save(person);
    }
    public Person update(Long id, Person person) {
    	Optional<Person> optPerson = this.findId(id);
    	if(optPerson.isEmpty()) {
    		throw new PersonExcpetion("Paciente não encontrado!"); 
    	}
    return add(person);
    }

    
    public Optional<Person> findId(Long id){
    	return repository.findById(id);
    }
    public List<Person> listAllPerson() {
        return repository.findAll();
    }
    public void delet(Long id) {
        repository.deleteById(id);
    }

}
