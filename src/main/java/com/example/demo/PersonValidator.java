package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.Person.Health;


public class PersonValidator implements Validator { 

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", "validation.message.field.required");

        Person person=(Person) target;
        if(person.getHealth()==Health.bad)
        {
        	if(person.getSuggestDoctor()==null || person.getSuggestDoctor().length()==0)
        	{
        		errors.rejectValue("suggestDoctor", "validation.message.field.required", null, null);
        	}
        }
    }

}