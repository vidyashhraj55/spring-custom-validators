package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@Validated 
public class PersonController {
	
	@Autowired
	PersonService personService;

	
	@GetMapping(value="/person")
	public List<Person> getPerson() {
		return personService.findAllpersons();
	}
	
	@PostMapping(value="/person")
	public Person postPerson(@Valid @RequestBody Person person) {
		
		return personService.addPerson(person);
	}
	
	@PutMapping(value="person/{id}")
	public Person putPerson(@PathVariable("id") int id, @RequestBody Person person) {
		
		return personService.updatePerson(person);
	}
	
	@DeleteMapping(value="person/{id}")
	public boolean deletePerson(@PathVariable("id") int id) {
		return personService.deletePerson(id);
	}
	@InitBinder("person")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new PersonValidator());
    }

}
