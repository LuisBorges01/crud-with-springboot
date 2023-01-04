package br.com.lsborges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.lsborges.model.Person;
import br.com.lsborges.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
	public Person create(@RequestBody Person person) {
		return services.createService(person);
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<Person> uptade(@PathVariable("id") long id, @RequestBody Person person) {
		return services.uptadeService(id, person);
	}
	
	
	
    @GetMapping("/{id}")
	public Person findbyId(@PathVariable("id") Long id) throws Exception {
    	 return services.findByIdService(id)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));	}
	
    
    
    
    
	@GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Person> findAll() {
		return services.findAllService();
	}

	

}
