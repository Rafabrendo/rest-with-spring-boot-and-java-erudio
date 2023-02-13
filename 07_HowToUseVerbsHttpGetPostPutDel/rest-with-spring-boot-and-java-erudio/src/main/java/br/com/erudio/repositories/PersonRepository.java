package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Person;

//Só isso aqui é o suficiente para executar um CRUD basico
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
