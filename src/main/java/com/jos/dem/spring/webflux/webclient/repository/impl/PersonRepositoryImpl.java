package com.jos.dem.spring.webflux.webclient.repository.impl;

import java.util.Map;
import java.util.HashMap;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;

public class PersonRepositoryImpl implements PersonRepository {

  private Map<String, Person> persons = new HashMap<>();

  public void save(Person person){
    persons.put(person.getNickname(), person);
  }

}
