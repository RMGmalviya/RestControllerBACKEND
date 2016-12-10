package com.rest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public List<Person> getAllPersons() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Person");
		List<Person>persons=query.list();
		session.close();
		return persons;
	}

	public Person getPersonById(int id) {
		Session session=sessionFactory.openSession();
		Person person=(Person)session.get(Person.class,id);
		session.close();
		return person;
	}

	public void savePerson(Person person) {
		Session session=sessionFactory.openSession();
		session.save(person);
        session.flush();
        session.close();

	}
@Transactional
	public Person updatePerson(int id, Person person) {
	Session session=sessionFactory.openSession();
	System.out.println("Id of Person is" +person.getPersonId());
	if(session.get(Person.class,id)==null)
		return null;
	session.merge(person);
	Person updatedPerson=(Person)session.get(Person.class, id);
	session.flush();
	session.close();
	return updatedPerson;
	}

	public void deletePerson(int id) {
		Session session=sessionFactory.openSession();
		Person person=(Person)session.get(Person.class, id);
		session.delete(person);
		session.flush();
		session.close();

	}

}
