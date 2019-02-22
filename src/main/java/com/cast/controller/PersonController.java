package com.cast.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cast.entity.Person;
import com.cast.service.PersonService;

/**
 * @author ivaldo
 * Coment: Classe que controladora que recebe as requisições solicitadas
 * 
 */

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

	
	@RequestMapping(value = "/createPerson", method = RequestMethod.POST)
	public ResponseEntity<?> createPerson(@RequestBody Map<String, Person> params) {
		try {
			
			personService.createPerson(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getMessage());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/getAllPersons", method = RequestMethod.GET)
	public ResponseEntity<?> getAllPersons() {
		try {
			List<Person> list = personService.getAllPersons();
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
	public ResponseEntity<?> deletePerson(@RequestBody Map<String, Person> params) {
		try {
			
			personService.deletePerson(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getStackTrace().toString());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
	public ResponseEntity<?> editPerson(@RequestBody Map<String, Person> params) {
		try {
			
			personService.updatePerson(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/getPersonById", method = RequestMethod.POST)
	public ResponseEntity<?> getPersonById(@RequestBody String id) {
		try {
			Person p = personService.getPersonById(Long.parseLong(id));
			return ResponseEntity.ok(p);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
