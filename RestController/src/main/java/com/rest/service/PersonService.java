package com.rest.service;

import java.util.List;

import com.rest.model.Person;

public interface PersonService {
	List<Person>getAllPersons();
	Person getPersonById(int id);
	void savePerson(Person person);
	Person updatePerson(int id,Person person);
	void deletePerson(int id);

}
