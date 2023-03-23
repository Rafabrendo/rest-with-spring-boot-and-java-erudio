package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Person;

//Só isso aqui é o suficiente para executar um CRUD basico
//@Repository //Essa annotetion não é mais necessaria, é uma atualização do spring. Apenas o extends JpaRepository é suficiente. 
public interface PersonRepository extends JpaRepository<Person, Long> {}
