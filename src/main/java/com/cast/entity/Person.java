package com.cast.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ivaldo
 * Coment: Classe que representa o modelo
 * 
 */
@Entity
@Table(name="tb_person")
@SequenceGenerator(name = "SEQ_USER", sequenceName = "SEQ_USER", initialValue=1, allocationSize=1)
public class Person implements Serializable{


	@Id
	@GeneratedValue(generator = "SEQ_USER", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="street")
	private String street;

	@Column(name="number")
	private Integer number;

	@Column(name="neighborhood")
	private String neighborhood;

	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="phone")
	private String phone;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
	public Person() {
	
	}

	public Person(String name, String street, Integer number, String neighborhood, String city, String state,
			String cellphone, String phone) {
		super();
		this.name = name;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.cellphone = cellphone;
		this.phone = phone;
	}
	
	
	
}
