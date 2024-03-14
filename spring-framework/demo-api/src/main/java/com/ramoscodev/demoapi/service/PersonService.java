package com.ramoscodev.demoapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.*;

import org.springframework.stereotype.Service;

import com.ramoscodev.demoapi.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	private List<String> myList = Arrays.asList("John", "Ben", "Gregor", "Peter", "Maria", "Maria Alice", "Ademario", "Luisa", "Marivania", "Chris");
	private List<Person> persons = new ArrayList<>();

	public Person create(Person person) {
		logger.info("Creating a person!");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		
		return person;
	}
	
	public Person delete(String id) {
		logger.info("Deleting one person!");
		
		return findById(id);
	}
	
	public List<Person> findAll() {
		
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setId(counter.incrementAndGet());
			p.setFirstName(myList.get(i));
			p.setLastName("Alves Fernandes");
			p.setAddress("Rua Hercules Malatesta," + (i + 23));
			if((myList.get(i) == "Maria") || (myList.get(i) == "Maria Alice") || (myList.get(i) == "Luisa")) {
				p.setGender("Female");
			}else {
				p.setGender("Male");
			}
			persons.add(p);
		}
		return persons;
	}
	
	public Person findById(String id) {
		logger.info("Finding " + id + " person!");
		
		Person p = new Person();
		p.setId(counter.incrementAndGet());
		
		if(Integer.parseInt(id) >= 2) {
			p.setFirstName("Maria Alice");
			p.setLastName("Alves Fernandes");
			p.setAddress("Rua Hercules Malatesta, 44");
			p.setGender("Female");
		}else {
			p.setFirstName("Marivania");
			p.setLastName("Alves Fernandes");
			p.setAddress("Rua Hercules Malatesta, 44");
			p.setGender("Female");
		}
		
		
		return p;
	}
}
