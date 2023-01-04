package br.com.lsborges.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lsborges.model.Person;
import br.com.lsborges.model.PersonServices;

@RestController
@RequestMapping({"/cadastro"})
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@PostMapping("/set")
	public Person create(@RequestBody Person person) {
		return services.createService(person);
	}
	
	@PutMapping(value ="/update")
	public Person uptade(@Validated Person person) {
		return services.uptadeService(person);
	}
	
    @GetMapping("/busque/{id}")
	public Optional<Person>  findbyId(@PathVariable("id") Long id) throws Exception {
		return services.findByIdService(id);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(services.findAllService());
	}

	

}
