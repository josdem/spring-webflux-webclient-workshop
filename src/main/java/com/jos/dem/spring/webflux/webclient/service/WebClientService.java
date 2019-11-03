package com.jos.dem.spring.webflux.webclient.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.jos.dem.spring.webflux.webclient.model.Person;

public interface WebClientService {

  Mono<String> getGreetings();
  Mono<HttpHeaders> getHeaders();
  Flux<Person> getAll();
  Mono<Person> getPerson(String nickname);
  Mono<ClientResponse> getPersonAsClientResponse(String nickname);


}
