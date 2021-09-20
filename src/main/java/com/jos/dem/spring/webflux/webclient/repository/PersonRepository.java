package com.jos.dem.spring.webflux.webclient.repository;

import com.jos.dem.spring.webflux.webclient.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
  void save(Person person);

  Flux<Person> findAll();

  Mono<Person> findByNickname(String nickname);
}
