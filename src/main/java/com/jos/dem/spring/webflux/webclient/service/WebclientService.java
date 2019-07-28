package com.jos.dem.spring.webflux.webclient.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.http.HttpHeaders;

import com.jos.dem.spring.webflux.webclient.model.Person;

public interface WebclientService {

  Mono<String> getGreetings();
  Mono<HttpHeaders> getHeaders();
  Flux<Person> getAll();
  Mono<Person> getPerson(String nickname);


}
