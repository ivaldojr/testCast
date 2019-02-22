package com.myappexample;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cast.entity.Person;
import com.cast.repository.PersonRepository;


/**
 * @author ivaldo
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;
	@Rule
	public ExpectedException trhown = ExpectedException.none();
	
	/**
	 *Testa a criação de um usuário através da interface JPA 
	 */
	@Test
	public void createUserPersistDataTest(){
		Person userTest = new Person("Usuário Teste","Rua 10, casa 100",1500,"A","Comum", "Sim", "21345.67", "12345.10");
		this.personRepository.save(userTest);
		
		
		Assertions.assertThat(userTest.getId()).isNotNull();
		Assertions.assertThat(userTest.getName()).isEqualTo("Usuário Teste");
		Assertions.assertThat(userTest.getStreet()).isEqualTo("Rua 10, casa 100");
		Assertions.assertThat(userTest.getNumber()).isEqualTo(1500);
		Assertions.assertThat(userTest.getNeighborhood()).isEqualTo("A");
		Assertions.assertThat(userTest.getCity()).isEqualTo("Comum");
		Assertions.assertThat(userTest.getState()).isEqualTo("Sim");
		Assertions.assertThat(userTest.getCellphone()).isEqualTo("21345.67");
		Assertions.assertThat(userTest.getPhone()).isEqualTo("12345.10");
		
		//Após a validação remove o registro de teste
		personRepository.delete(userTest);
	}
	

	/**
	 *Testa a exclusão de um usuário através da interface JPA 
	 */
	@Test
	public void deleteUserDataTest(){
		Person userTest = new Person("Usuário Teste","Rua 10, casa 100",1500,"A","Comum", "Sim", "21345.67", "12345.10");
		this.personRepository.save(userTest);
		personRepository.delete(userTest);
		
		Assertions.assertThat(personRepository.findById(userTest.getId())).isEmpty();
	}
	
	/**
	 *Testa a atualização de um usuário através da interface JPA 
	 */
	@Test
	public void updateUserDataTest(){
		Person userTest = new Person("Usuário Teste","Rua 10, casa 100",1500,"A","Comum", "Sim", "21345.67", "12345.10");
		this.personRepository.save(userTest);


		userTest.setName("Usuário updated");
		userTest.setStreet("Rua 200, casa 2B");
		userTest.setNumber(3500);
		userTest.setNeighborhood("B");
		userTest.setCity("Potencial");
		userTest.setState("Não");
		userTest.setCellphone("30000.67");
		userTest.setPhone("500.00");
		
		userTest = this.personRepository.save(userTest);
		
		Assertions.assertThat(userTest.getName()).isEqualTo("Usuário updated");
		Assertions.assertThat(userTest.getStreet()).isEqualTo("Rua 200, casa 2B");
		Assertions.assertThat(userTest.getNumber()).isEqualTo(3500);
		Assertions.assertThat(userTest.getNeighborhood()).isEqualTo("B");
		Assertions.assertThat(userTest.getCity()).isEqualTo("Potencial");
		Assertions.assertThat(userTest.getState()).isEqualTo("Não");
		Assertions.assertThat(userTest.getCellphone()).isEqualTo(30000.67);
		Assertions.assertThat(userTest.getPhone()).isEqualTo(500.00);
	}
	
	
}
