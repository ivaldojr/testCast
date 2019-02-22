package com.cast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cast.entity.Person;


/**
 * @author ivaldo
 * Coment: Classe de interface do repositório de cliente
 * 
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {



}
