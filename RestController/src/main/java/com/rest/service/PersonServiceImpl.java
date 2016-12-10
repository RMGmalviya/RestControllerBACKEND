package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.PersonDao;
import com.rest.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	public PersonDao getpersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao=personDao;
	}

	public List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}

	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

	public void savePerson(Person person) {
           personDao.savePerson(person);
	}
	public Person updatePerson(int id, Person person) {
		return personDao.updatePerson(id, person);
	}
	public void deletePerson(int id) {
		personDao.deletePerson(id);

	}

}
