package com.cast.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cast.entity.Person;
import com.cast.repository.PersonRepository;

/**
 * @author ivaldo
 * Coment: Classe que implementa os métodos de serviço
 * 
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	/**
	 * Método utilizado para criar um novo cliente
	 * 
	 */
	@Override
	public void createPerson(Map<String, Person> params) {
		personRepository.save(params.get("data"));
	}
	
	/**
	 *  Método utilizado para listar os clientes
	 * @return liste de clientes ordenados pelo mais recente
	 */
	@Override
	public List <Person> getAllPersons(){
		return personRepository.findAll(sortByIdDesc());
	}
	
	private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
	
	/**
	 *  Método utilizado para remover um cliente
	 * 
	 */
	@Override
	public void deletePerson(Map<String, Person> params) {
		personRepository.deleteById(params.get("data").getId());
	}

	/**
	 *  Método utilizado para atualizar um clientee
	 * 
	 */
	@Override
	public void updatePerson(Map<String, Person> params) {
		
		Optional<Person> p = personRepository.findById(params.get("data").getId());
		
		p.get().setName(params.get("data").getName());
		p.get().setStreet(params.get("data").getStreet());
		p.get().setNumber(params.get("data").getNumber());
		p.get().setNeighborhood(params.get("data").getNeighborhood());
		p.get().setCity(params.get("data").getCity());
		p.get().setState(params.get("data").getState());
		p.get().setCellphone(params.get("data").getCellphone());
		p.get().setPhone(params.get("data").getPhone());
		
		personRepository.save(p.get());
	}

	@Override
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id).get();
	}
	
}
	

