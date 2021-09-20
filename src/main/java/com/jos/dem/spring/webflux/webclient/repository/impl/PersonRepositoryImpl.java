package com.jos.dem.spring.webflux.webclient.repository.impl;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonRepositoryImpl implements PersonRepository {

  private Map<String, Person> persons = new HashMap<>();

  public void save(Person person) {
    persons.put(person.getNickname(), person);
  }

  public Flux<Person> findAll() {
    return Flux.fromIterable(persons.values());
  }

  public Mono<Person> findByNickname(String nickname) {
    return Mono.just(persons.get(nickname));
  }
}
