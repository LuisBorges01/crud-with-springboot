package br.com.lsborges.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import br.com.lsborges.model.Endereco;
import br.com.lsborges.model.Person;
import br.com.lsborges.model.respository.EndereçoRepository;
import br.com.lsborges.model.respository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@SuppressWarnings("unused")
	@Autowired
	private EndereçoRepository enderecoRepository;
	
	public Person createService(Person person) {	
		personRepository.save(person);
		return person;
	}
	
	public ResponseEntity<Person> uptadeService(long id, Person personReceived){
		Optional<Person> personExistis = personRepository.findById(id);
			
			Person newPerson = personExistis.get();
			newPerson.setName(personReceived.getName());
			newPerson.setBirthDate(personReceived.getBirthDate());
			newPerson.setEndereço(personReceived.getEndereço());
			return new ResponseEntity<Person>(personRepository.save(newPerson), HttpStatus.OK);
	}
	
	public Optional<Person> findByIdService(Long id) throws Exception {
		return personRepository.findById(id);
		}
	

	public List<Person> findAllService(){
		return personRepository.findAll();
	}	
	
	
	public Person enderecoPorPessoa(Long id, List<Endereco> enderecoReceived) {
		Optional<Person> newAddress = personRepository.findById(id);
		Person novoEndereco = newAddress.get();
		novoEndereco.setEndereço(enderecoReceived);
		return novoEndereco;
		}
		
		/*try {
			findByIdService(id);
		} catch (Exception e) {
			System.out.print("ID INVÁLIDO!");
		}
		Optional<Person> idPerson = personRepository.findById(id);
		Person newAddressPerson = idPerson.get();
		newAddressPerson.setEndereço(endereco);
		return Optional.ofNullable(newAddressPerson);	*/
	
}
