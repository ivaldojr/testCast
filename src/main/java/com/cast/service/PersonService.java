package com.cast.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cast.entity.Person;


/**
 * @author ivaldo
 * Coment: Classe que representa a interface do servico de cliente
 * 
 */
public interface PersonService {

	public void createPerson(Map<String, Person> params);

	public List<Person> getAllPersons();
	
	public void deletePerson(Map<String, Person> params);
	
	public void updatePerson(Map<String, Person> params);

	public Person getPersonById(Long id);


	
	
}
