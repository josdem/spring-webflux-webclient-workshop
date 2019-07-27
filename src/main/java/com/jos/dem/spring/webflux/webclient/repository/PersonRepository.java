package com.jos.dem.spring.webflux.webclient.repository;

import reactor.core.publisher.Flux;

import com.jos.dem.spring.webflux.webclient.model.Person;

public interface PersonRepository {
  void save(Person person);
  Flux<Person> getAll();
}
