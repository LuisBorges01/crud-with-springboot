package br.com.lsborges.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lsborges.DTO.Mapper.PersonMapper;
import br.com.lsborges.DTO.config.PersonRequest;
import br.com.lsborges.DTO.config.PersonResponse;
import br.com.lsborges.model.Person;
import br.com.lsborges.service.PersonService;

@RestController
@RequestMapping("/pessoa")
public class Controller {
	@Autowired
    private PersonService service;
	@Autowired
    private PersonMapper mapper;
    
   /* @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest request) {
        Optional<PersonResponse> optPaciente = Stream.of(request)
                .map(mapper::toPaciente)
                .map(service::add)
                .map(mapper::toPacienteResponse)
                .findFirst();
        return ResponseEntity.status(HttpStatus.CREATED).body(optPaciente.get());
    }*/
    
    @PostMapping
    public Person createPerson(@RequestBody Person request) {
        return service.add(request);
    }
    
    /*@PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }*/
    
    
    
    @GetMapping
    public ResponseEntity<List<PersonResponse>> listarTodos() {
        List<PersonResponse> personResponses = service.listAllPerson()
                .stream()
                .map(mapper::toPersonResponse)
                .collect(Collectors.toList());
 
        return ResponseEntity.status(HttpStatus.OK).body(personResponses);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> alterar(@PathVariable Long id, @RequestBody PersonRequest request) {
        return Stream.of(request)
                .map(mapper::toPerson)
                .map(person -> service.update(id, person))
                .map(mapper::toPersonResponse)
                .map(PersonResponse -> ResponseEntity.status(HttpStatus.OK).body(PersonResponse))
                .findFirst()
                .get();
    }
	
	

}
