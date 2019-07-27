package com.jos.dem.spring.webflux.webclient.repository;

import com.jos.dem.spring.webflux.webclient.model.Person;

public interface PersonRepository {
  void save(Person person);
}
