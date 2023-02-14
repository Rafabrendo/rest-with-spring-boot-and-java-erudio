package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all people!");
		/*
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
			
		}
		*/
		
		return repository.findAll() ;
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		//Person person = new Person();
		
		//mocking
		//person.setId(counter.incrementAndGet());
		//person.setFirstName("Rafael");
		//person.setLastName("Reis");
		//person.setAddress("Brasília - DF - Brasil");
		//person.setGender("Male");
		//return person;
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		//posso usar Person ou var
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		
		
	}
	
	/*
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}
	*/
}
