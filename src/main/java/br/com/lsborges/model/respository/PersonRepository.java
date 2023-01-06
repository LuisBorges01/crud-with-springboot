package br.com.lsborges.model.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lsborges.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
