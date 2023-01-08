package br.com.lsborges.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lsborges.model.Person;


public interface RepositoryPerson extends JpaRepository<Person, Long>{}
