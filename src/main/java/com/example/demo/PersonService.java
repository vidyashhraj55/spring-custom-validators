package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personrepository;

	public Person addPerson(Person person) {
		return personrepository.save(person);
	}
	
	
	public Person findPerson(int id) {
		return personrepository.getOne(id);
	}
	public List<Person> findAllpersons() {
		return personrepository.findAll();
	}
	public Person updatePerson(Person person ) {
		return personrepository.save(person);
	}
	public boolean deletePerson(int id) {
		Person person=findPerson(id);
		if(person!=null) {
		 personrepository.delete(person);
		return true;
	}
	else {
		return false;
	}
	}

}
