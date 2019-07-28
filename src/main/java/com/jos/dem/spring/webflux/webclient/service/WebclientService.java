package com.jos.dem.spring.webflux.webclient.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.http.HttpHeaders;

import com.jos.dem.spring.webflux.webclient.model.Person;

public interface WebclientService {

  Flux<Person> findAll();
  Mono<HttpHeaders> getHeaders();

}
