package com.jos.dem.spring.webflux.webclient.service;

public interface WebfluxService {

  Mono<String> getGreetings();
  Mono<HttpHeaders> getHeaders();

}
